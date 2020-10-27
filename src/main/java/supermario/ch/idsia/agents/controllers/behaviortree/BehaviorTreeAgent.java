package supermario.ch.idsia.agents.controllers.behaviortree;

import supermario.ch.idsia.agents.Agent;
import supermario.ch.idsia.benchmark.mario.environments.Environment;

public class BehaviorTreeAgent implements Agent {

    private TaskDto taskDto = new TaskDto();
    private final TreeTask root;
    private String name;

    private static final int Z_LEVEL_SCENE = 1;
    private static final int Z_LEVEL_ENEMIES = 0;

    public BehaviorTreeAgent(String name, TreeTask root) {
        this.name = name;
        this.root = root;
    }

    @Override
    public void reset() {
        taskDto = new TaskDto();
    }

    @Override
    public boolean[] getAction() {
        root.run(taskDto);
        return taskDto.action;
    }

    @Override
    public void integrateObservation(Environment environment) {
        // First observation
        taskDto.environment = environment;
        taskDto.levelScene = environment.getLevelSceneObservationZ(Z_LEVEL_SCENE);
        taskDto.enemies = environment.getEnemiesObservationZ(Z_LEVEL_ENEMIES);

        float[] marioPos = taskDto.environment.getMarioFloatPos();
        if (marioPos[0] > taskDto.farthestProgress) {
            taskDto.farthestProgress = marioPos[0];
            taskDto.farthestProgressTimestamp = environment.getTimeSpent();
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
