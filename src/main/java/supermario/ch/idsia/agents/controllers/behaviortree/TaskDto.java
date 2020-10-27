package supermario.ch.idsia.agents.controllers.behaviortree;

import supermario.ch.idsia.benchmark.mario.environments.Environment;

class TaskDto {

    boolean[] action = new boolean[Environment.numberOfKeys];

    Environment environment;
    byte[][] levelScene;
    byte[][] enemies;

    int movementSemaphore;
    float farthestProgress;
    int farthestProgressTimestamp;

    int getMarioEgoPosRow() {
        int[] egoPos = environment.getMarioEgoPos();
        return egoPos[0];
    }

    int getMarioEgoPosCol() {
        int[] egoPos = environment.getMarioEgoPos();
        return egoPos[1];
    }

    int getEnemiesCellValue(int x, int y) {
        if (x < 0 || x >= levelScene.length || y < 0 || y >= levelScene[0].length)
            return 0;

        return enemies[x][y];
    }

    int getReceptiveFieldCellValue(int x, int y) {
        if (x < 0 || x >= levelScene.length || y < 0 || y >= levelScene[0].length)
            return 0;

        return levelScene[x][y];
    }
}
