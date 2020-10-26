package supermario.ch.idsia.agents.controllers.behaviortree;

import supermario.ch.idsia.benchmark.mario.environments.Environment;

class Blackboard {

    boolean[] action;

    Environment environment;
    byte[][] levelScene;
    byte[][] enemies;

    int marioEgoRow;
    int marioEgoCol;
    int receptiveFieldWidth;
    int receptiveFieldHeight;


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
