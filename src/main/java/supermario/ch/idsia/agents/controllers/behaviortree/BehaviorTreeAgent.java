package supermario.ch.idsia.agents.controllers.behaviortree;

import supermario.ch.idsia.agents.Agent;
import supermario.ch.idsia.benchmark.mario.environments.Environment;

public class BehaviorTreeAgent implements Agent {

    private GameStateDto gameStateDto = new GameStateDto();
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
        gameStateDto = new GameStateDto();
    }

    @Override
    public boolean[] getAction() {
        root.run(gameStateDto);
        return gameStateDto.action;
    }

    @Override
    public void integrateObservation(Environment environment) {
        // First observation
        gameStateDto.environment = environment;
        gameStateDto.levelScene = environment.getLevelSceneObservationZ(Z_LEVEL_SCENE);
        gameStateDto.enemies = environment.getEnemiesObservationZ(Z_LEVEL_ENEMIES);

        float[] marioPos = gameStateDto.environment.getMarioFloatPos();
        if (marioPos[0] > gameStateDto.farthestProgress) {
            gameStateDto.farthestProgress = marioPos[0];
            gameStateDto.farthestProgressTimestamp = environment.getTimeSpent();
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
