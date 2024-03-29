package supermario.ch.idsia.agents.controllers.behaviortree;

import supermario.ch.idsia.benchmark.mario.engine.GeneralizerLevelScene;
import supermario.ch.idsia.benchmark.mario.environments.Environment;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import static supermario.ch.idsia.agents.controllers.behaviortree.BehaviorTree.blackboard;

@XmlRootElement(name="wallahead")
public class WallAheadCondition implements TreeTask {

    @XmlAttribute(name="ahead")
    private int aheadDistance;

    @XmlAttribute(name="down")
    private int downDistance;

    @XmlAttribute(name="up")
    private int upDistance;

    @Override
    public boolean run() {
        boolean[] action = BlackboardHelper.getAction(blackboard);

        int row = BlackboardHelper.getMarioEgoPosRow(blackboard);
        int col = BlackboardHelper.getMarioEgoPosCol(blackboard);
        int colItr = action[Environment.MARIO_KEY_RIGHT] ? 1 : -1;


        for (int i = colItr; i-colItr != colItr*aheadDistance; i+=colItr) {
            for (int j = 0; j <= upDistance; j++) {
                int kind = BlackboardHelper.getReceptiveFieldCellValue(blackboard, row-j, col+i);
                if (isBlocker(kind)) return true;
            }

            for (int j = 0; j <= downDistance; j++) {
                int kind = BlackboardHelper.getReceptiveFieldCellValue(blackboard, row+j, col+i);
                if (isBlocker(kind)) return true;
            }
        }

        return false;
    }

    private boolean isBlocker(int kind) {
        switch (kind) {
            case GeneralizerLevelScene.CANNON_MUZZLE:
            case GeneralizerLevelScene.CANNON_TRUNK:
            case GeneralizerLevelScene.BREAKABLE_BRICK:
            case GeneralizerLevelScene.UNBREAKABLE_BRICK:
            case GeneralizerLevelScene.BRICK:
            case GeneralizerLevelScene.FLOWER_POT:
            case GeneralizerLevelScene.BORDER_CANNOT_PASS_THROUGH:
            case GeneralizerLevelScene.BORDER_HILL: // FIXME is this correct?
            case GeneralizerLevelScene.FLOWER_POT_OR_CANNON:
                return true;
            default:
                return false;
        }
    }
}
