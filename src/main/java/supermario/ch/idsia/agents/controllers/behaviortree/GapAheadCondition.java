package supermario.ch.idsia.agents.controllers.behaviortree;

import supermario.ch.idsia.benchmark.mario.engine.GeneralizerLevelScene;
import supermario.ch.idsia.benchmark.mario.environments.Environment;

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
        if (!BehaviorTreeAgent.blackboard.environment.isMarioOnGround()) {
            return false;
        }

        int row = BehaviorTreeAgent.blackboard.getMarioEgoPosRow();
        int col = BehaviorTreeAgent.blackboard.getMarioEgoPosCol();
        int colItr = BehaviorTreeAgent.blackboard.action[Environment.MARIO_KEY_RIGHT] ? 1 : -1;

        for (int i = colItr; i-colItr != colItr*aheadDistance; i+=colItr) {
            for (int j = 0; j <= downDistance; j++) {
                int kind = BehaviorTreeAgent.blackboard.getReceptiveFieldCellValue(row+j, col+i);
                if (kind == 0) return true;
            }
        }

        return false;
    }
}
