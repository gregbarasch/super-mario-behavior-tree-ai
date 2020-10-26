package supermario.ch.idsia.agents.controllers.behaviortree;

import supermario.ch.idsia.agents.Agent;
import supermario.ch.idsia.benchmark.mario.environments.Environment;

public class BehaviorTreeAgent implements Agent {

    static final Blackboard blackboard = new Blackboard();
    private final TreeTask root;
    private String name;

    private static final int Z_LEVEL_SCENE = 1;
    private static final int Z_LEVEL_ENEMIES = 0;

    public BehaviorTreeAgent(String name, TreeTask root) {
        this.name = name;
        this.root = root;
        blackboard.action = new boolean[Environment.numberOfKeys];

        reset();
    }

    @Override
    public void reset() {
        blackboard.action = new boolean[Environment.numberOfKeys];
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
