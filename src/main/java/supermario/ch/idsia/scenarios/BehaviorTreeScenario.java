package supermario.ch.idsia.scenarios;

import supermario.ch.idsia.agents.controllers.behaviortree.*;
import supermario.ch.idsia.benchmark.mario.environments.Environment;
import supermario.ch.idsia.benchmark.mario.environments.MarioEnvironment;
import supermario.ch.idsia.tools.MarioAIOptions;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class BehaviorTreeScenario {

    public static void main(String[] args) throws JAXBException {
        // JAXB
        JAXBContext context = JAXBContext.newInstance(
                Selector.class, Sequence.class,

                CanJumpCondition.class, DoneJumpingCondition.class, CanShootCondition.class, EnemyAheadCondition.class,
                EnemyLeftCondition.class, StompableEnemyLeftCondition.class, CoinLeftCondition.class, MovementLockedCondition.class,
                WastingTimeCondition.class, RunningOutOfTimeCondition.class,

                JumpAction.class, LandAction.class, RightAction.class, LeftAction.class, ReverseDirectionAction.class,
                ShootAction.class, ShootCompleteAction.class, DecrementMovementSemaphoreAction.class, SetMovementSemaphoreAction.class
        );
        Unmarshaller unmarshaller = context.createUnmarshaller();

        // Agent
        TreeTask root = (TreeTask) unmarshaller.unmarshal(new File("src/main/java/supermario/ch/idsia/agents/controllers/behaviortree/resources/t1.xml"));
        BehaviorTreeAgent agent = new BehaviorTreeAgent("BTree Test", root);

        // Options
        final MarioAIOptions options = new MarioAIOptions(args);
        options.setAgent(agent);
//        options.setLevelDifficulty(1);
//        int level = 5; //Math.abs(new Random().nextInt());
//        options.setLevelRandSeed(level);

        // Env
        Environment environment = MarioEnvironment.getInstance();
        environment.reset(options);

        // Main loop
        while (!environment.isLevelFinished()) {
            environment.tick();
            agent.integrateObservation(environment);
            agent.giveIntermediateReward(environment.getIntermediateReward());
            environment.performAction(agent.getAction());
        }
    }
}
