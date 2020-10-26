package supermario.ch.idsia.agents.controllers.behaviortree;

import supermario.ch.idsia.agents.Agent;
import supermario.ch.idsia.benchmark.mario.environments.Environment;

public class BehaviorTreeAgent implements Agent {

    static final Blackboard blackboard = new Blackboard();
    private final TreeTask root;
    private String name;

    private int zLevelScene = 1;
    private int zLevelEnemies = 0;

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
        blackboard.environment = environment;
        blackboard.levelScene = environment.getLevelSceneObservationZ(zLevelScene);
        blackboard.enemies = environment.getEnemiesObservationZ(zLevelEnemies);
    }

    @Override
    public void giveIntermediateReward(float intermediateReward) {}

    @Override
    public void setObservationDetails(final int rfWidth, final int rfHeight, final int egoRow, final int egoCol) {
        blackboard.receptiveFieldWidth = rfWidth;
        blackboard.receptiveFieldHeight = rfHeight;

        blackboard.marioEgoRow = egoRow;
        blackboard.marioEgoCol = egoCol;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
