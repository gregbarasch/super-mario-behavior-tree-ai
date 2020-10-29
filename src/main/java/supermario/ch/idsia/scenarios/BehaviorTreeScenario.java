package supermario.ch.idsia.scenarios;

import supermario.ch.idsia.agents.controllers.behaviortree.*;
import supermario.ch.idsia.benchmark.mario.environments.Environment;
import supermario.ch.idsia.benchmark.mario.environments.MarioEnvironment;
import supermario.ch.idsia.tools.MarioAIOptions;

import javax.xml.bind.JAXBException;
import java.util.Random;

public class BehaviorTreeScenario {

    public static void main(String[] args) throws JAXBException {
        // Agent
        BehaviorTreeAgent agent = new BehaviorTreeAgent("BTree Test", "src/main/java/supermario/ch/idsia/agents/controllers/behaviortree/resources/t1.xml");

        // Options
        final MarioAIOptions options = new MarioAIOptions(args);
        options.setAgent(agent);
//        options.setLevelDifficulty(0);
//        int level = Math.abs(new Random(System.currentTimeMillis()).nextInt());
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
