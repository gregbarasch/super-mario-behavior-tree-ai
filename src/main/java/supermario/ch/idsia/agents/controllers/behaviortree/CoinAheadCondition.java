package supermario.ch.idsia.agents.controllers.behaviortree;

import supermario.ch.idsia.benchmark.mario.environments.Environment;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import static supermario.ch.idsia.agents.controllers.behaviortree.BehaviorTree.*;
import static supermario.ch.idsia.benchmark.mario.engine.GeneralizerLevelScene.COIN_ANIM;

@XmlRootElement(name="coinahead")
public class CoinAheadCondition implements TreeTask {

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
                if (BlackboardHelper.getReceptiveFieldCellValue(blackboard, row-j, col+i) == COIN_ANIM) return true;
            }

            for (int j = 1; j <= downDistance; j++) {
                if (BlackboardHelper.getReceptiveFieldCellValue(blackboard, row+j, col+i) == COIN_ANIM) return true;
            }
        }

        return false;
    }
}
