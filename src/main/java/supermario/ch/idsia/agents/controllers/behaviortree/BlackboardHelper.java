package supermario.ch.idsia.agents.controllers.behaviortree;

import supermario.ch.idsia.benchmark.mario.environments.Environment;

/**
 * This class was created for convenience. Makes it easy to query the blackboard
 * TODO if multiple trees are used simultaneously, then this helper will need to be adjusted to accept some form of identifier
 */
public class BlackboardHelper {

    // some static key values for convenience
    public static final String ACTION = "action";
    public static final String ENVIRONMENT = "environment";
    public static final String LEVEL_SCENE = "levelScene";
    public static final String ENEMIES = "enemies";
    public static final String MOVEMENT_SEMAPHORE = "movementSemaphore";
    public static final String FARTHEST_PROGRESS = "farthestProgress";
    public static final String FARTHEST_PROGRESS_TIMESTAMP = "farthestProgressTimestamp";

    public static boolean[] getAction(Blackboard blackboard) {
        Object action = blackboard.get(ACTION);
        if (action == null) {
            blackboard.put(ACTION, new boolean[Environment.numberOfKeys]);
        }
        return (boolean[]) blackboard.get(ACTION);
    }

    public static Environment getEnvironment(Blackboard blackboard) {
        return (Environment) blackboard.get(ENVIRONMENT);
    }

    public static byte[][] getLevelScene(Blackboard blackboard) {
        return (byte[][]) blackboard.get(LEVEL_SCENE);
    }

    public static byte[][] getEnemeies(Blackboard blackboard) {
        return (byte[][]) blackboard.get(ENEMIES);
    }

    public static int getMovementSemaphore(Blackboard blackboard) {
        Object sempaphore = blackboard.get(MOVEMENT_SEMAPHORE);
        if (sempaphore == null) return 0;
        return (int) sempaphore;
    }

    public static void decrementMovementSempahore(Blackboard blackboard) {
        int ms = getMovementSemaphore(blackboard);
        blackboard.put(MOVEMENT_SEMAPHORE, --ms);
    }

    public static float getFarthestProgress(Blackboard blackboard) {
        Object farthestProgress = blackboard.get(FARTHEST_PROGRESS);
        if (farthestProgress == null) return 0;
        return (float) farthestProgress;
    }

    public static int getFarthestProgressTimetamp(Blackboard blackboard) {
        Object farthestProgressTimestamp = blackboard.get(FARTHEST_PROGRESS_TIMESTAMP);
        if (farthestProgressTimestamp == null) return 0;
        return (int) farthestProgressTimestamp;
    }

    public static int getMarioEgoPosRow(Blackboard blackboard) {
        int[] egoPos = getEnvironment(blackboard).getMarioEgoPos();
        return egoPos[0];
    }

    public static int getMarioEgoPosCol(Blackboard blackboard) {
        int[] egoPos = getEnvironment(blackboard).getMarioEgoPos();
        return egoPos[1];
    }

    public static int getEnemiesCellValue(Blackboard blackboard, int x, int y) {
        byte[][] levelScene = getLevelScene(blackboard);
        if (x < 0 || x >= levelScene.length || y < 0 || y >= levelScene.length)
            return 0;

        return getEnemeies(blackboard)[x][y];
    }

    public static int getReceptiveFieldCellValue(Blackboard blackboard, int x, int y) {
        byte[][] levelScene = getLevelScene(blackboard);
        if (x < 0 || x >= levelScene.length || y < 0 || y >= levelScene[0].length)
            return 0;

        return levelScene[x][y];
    }
}
