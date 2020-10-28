package supermario.ch.idsia.agents.controllers.behaviortree;

import supermario.ch.idsia.benchmark.mario.environments.Environment;

import static supermario.ch.idsia.agents.controllers.behaviortree.BehaviorTree.*;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="gapahead")
public class GapAheadCondition implements TreeTask {

    @XmlAttribute(name="ahead")
    private int aheadDistance;

    @XmlAttribute(name="down")
    private int downDistance;

    @Override
    public boolean run() {
        Environment environment = BlackboardHelper.getEnvironment(blackboard);
        boolean[] action = BlackboardHelper.getAction(blackboard);

        if (!environment.isMarioOnGround()) {
            return false;
        }

        int row = BlackboardHelper.getMarioEgoPosRow(blackboard);
        int col = BlackboardHelper.getMarioEgoPosCol(blackboard);
        int colItr = action[Environment.MARIO_KEY_RIGHT] ? 1 : -1;


        for (int i = colItr; i-colItr != colItr*aheadDistance; i+=colItr) {
            for (int j = 0; j <= downDistance; j++) {
                int kind = BlackboardHelper.getReceptiveFieldCellValue(blackboard, row+j, col+i);
                if (kind == 0) return true;
            }
        }

        return false;
    }
}
