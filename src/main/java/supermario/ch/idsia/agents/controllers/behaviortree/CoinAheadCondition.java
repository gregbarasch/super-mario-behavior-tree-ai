package supermario.ch.idsia.agents.controllers.behaviortree;

import supermario.ch.idsia.benchmark.mario.environments.Environment;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import static supermario.ch.idsia.benchmark.mario.engine.GeneralizerLevelScene.COIN_ANIM;

@XmlRootElement(name="coinahead")
public class CoinAheadCondition implements TreeTask {

    @XmlAttribute(name="distance")
    private int aheadDistance;

    @XmlAttribute(name="down")
    private int downDistance;

    @XmlAttribute(name="up")
    private int upDistance;

    @Override
    public boolean run() {
        int row = BehaviorTreeAgent.blackboard.getMarioEgoPosRow();
        int col = BehaviorTreeAgent.blackboard.getMarioEgoPosCol();

        int colItr = BehaviorTreeAgent.blackboard.action[Environment.MARIO_KEY_RIGHT] ? 1 : -1;

        for (int i = colItr; i-colItr != colItr*aheadDistance; i+=colItr) {

            for (int j = 0; j <= upDistance; j++) {
                if (BehaviorTreeAgent.blackboard.getReceptiveFieldCellValue(row-j, col+i) == COIN_ANIM) System.out.println("forwardup");
                if (BehaviorTreeAgent.blackboard.getReceptiveFieldCellValue(row-j, col+i) == COIN_ANIM) return true;
            }

            for (int j = 1; j <= downDistance; j++) {
                if (BehaviorTreeAgent.blackboard.getReceptiveFieldCellValue(row+j, col+i) == COIN_ANIM) System.out.println("forwarddown");
                if (BehaviorTreeAgent.blackboard.getReceptiveFieldCellValue(row+j, col+i) == COIN_ANIM) return true;
            }
        }

        return false;
    }
}
