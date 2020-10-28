package supermario.ch.idsia.agents.controllers.behaviortree;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import static supermario.ch.idsia.agents.controllers.behaviortree.BehaviorTree.*;
import static supermario.ch.idsia.benchmark.mario.engine.GeneralizerLevelScene.COIN_ANIM;

@XmlRootElement(name="coinnear")
public class CoinNearCondition implements TreeTask {

    @XmlAttribute(name="left")
    private int leftDistance;

    @XmlAttribute(name="right")
    private int rightDistance;

    @XmlAttribute(name="down")
    private int downDistance;

    @XmlAttribute(name="up")
    private int upDistance;

    @Override
    public boolean run() {
        int row = BlackboardHelper.getMarioEgoPosRow(blackboard);
        int col = BlackboardHelper.getMarioEgoPosCol(blackboard);

        for (int i = 0; i <= leftDistance; i++) {
            for (int j = 0; j <= upDistance; j++) {
                if (BlackboardHelper.getReceptiveFieldCellValue(blackboard, row-j, col-i) == COIN_ANIM) return true;
            }

            for (int j = 0; j <= downDistance; j++) {
                if (BlackboardHelper.getReceptiveFieldCellValue(blackboard, row+j, col-i) == COIN_ANIM) return true;
            }
        }

        for (int i = 0; i < rightDistance; i++) {

            for (int j = 0; j <= upDistance; j++) {
                if (BlackboardHelper.getReceptiveFieldCellValue(blackboard, row-j, col+i) == COIN_ANIM) return true;
            }

            for (int j = 0; j <= downDistance; j++) {
                if (BlackboardHelper.getReceptiveFieldCellValue(blackboard, row+j, col-i) == COIN_ANIM) return true;
            }
        }

        return false;
    }
}
