package supermario.ch.idsia.agents.controllers.behaviortree;

import supermario.ch.idsia.agents.Agent;
import supermario.ch.idsia.benchmark.mario.environments.Environment;

public enum BehaviorTreeAgent implements Agent {

    INSTANCE;

    static Blackboard blackboard = new Blackboard();
    private TreeTask root;
    private String name;

    private static final int Z_LEVEL_SCENE = 1;
    private static final int Z_LEVEL_ENEMIES = 0;

    BehaviorTreeAgent() {}

    public void setRoot(TreeTask root) {
        this.root = root;
    }

    @Override
    public void reset() {
        blackboard = new Blackboard();
    }

    @Override
    public boolean[] getAction() {
        root.run();
        return blackboard.action;
    }

    @Override
    public void integrateObservation(Environment environment) {
        // First observation
        blackboard.environment = environment;
        blackboard.levelScene = environment.getLevelSceneObservationZ(Z_LEVEL_SCENE);
        blackboard.enemies = environment.getEnemiesObservationZ(Z_LEVEL_ENEMIES);

        float[] marioPos = blackboard.environment.getMarioFloatPos();
        if (marioPos[0] > blackboard.farthestProgress) {
            blackboard.farthestProgress = marioPos[0];
            blackboard.farthestProgressTimestamp = environment.getTimeSpent();
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
