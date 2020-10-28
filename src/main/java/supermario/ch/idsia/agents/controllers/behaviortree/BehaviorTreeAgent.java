package supermario.ch.idsia.agents.controllers.behaviortree;

import supermario.ch.idsia.agents.Agent;
import supermario.ch.idsia.benchmark.mario.environments.Environment;

import static supermario.ch.idsia.agents.controllers.behaviortree.BehaviorTree.*;

import javax.xml.bind.JAXBException;

public class BehaviorTreeAgent implements Agent {

    private final BehaviorTree behaviorTree;
    private String name;

    private static final int Z_LEVEL_SCENE = 1;
    private static final int Z_LEVEL_ENEMIES = 0;

    public BehaviorTreeAgent(String name, String btXml) throws JAXBException {
        this.name = name;
        this.behaviorTree = new BehaviorTree(btXml);
    }

    @Override
    public void reset() {
        behaviorTree.resetBlackboard();
    }

    @Override
    public boolean[] getAction() {
        behaviorTree.run();
        return BlackboardHelper.getAction(behaviorTree.getBlackboard());
    }

    @Override
    public void integrateObservation(Environment environment) {
        blackboard.put(BlackboardHelper.ENVIRONMENT, environment);
        blackboard.put(BlackboardHelper.LEVEL_SCENE, environment.getLevelSceneObservationZ(Z_LEVEL_SCENE));
        blackboard.put(BlackboardHelper.ENEMIES, environment.getEnemiesObservationZ(Z_LEVEL_ENEMIES));

        float[] marioPos = BlackboardHelper.getEnvironment(blackboard).getMarioFloatPos();
        if (marioPos[0] > BlackboardHelper.getFarthestProgress(blackboard)) {
            blackboard.put(BlackboardHelper.FARTHEST_PROGRESS, marioPos[0]);
            blackboard.put(BlackboardHelper.FARTHEST_PROGRESS_TIMESTAMP,
                    BlackboardHelper.getEnvironment(blackboard).getTimeSpent());
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void giveIntermediateReward(float intermediateReward) {}

    @Override
    public void setObservationDetails(final int rfWidth, final int rfHeight, final int egoRow, final int egoCol) {}
}
