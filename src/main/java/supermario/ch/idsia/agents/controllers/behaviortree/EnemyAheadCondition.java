package supermario.ch.idsia.agents.controllers.behaviortree;

import supermario.ch.idsia.benchmark.mario.environments.Environment;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="enemyahead")
public class EnemyAheadCondition implements TreeTask {

    @XmlAttribute(name="distance")
    private int searchDistance;

    @Override
    public boolean run() {
        int row = BehaviorTreeAgent.blackboard.getMarioEgoPosRow();
        int col = BehaviorTreeAgent.blackboard.getMarioEgoPosCol();

        int colItr = BehaviorTreeAgent.blackboard.action[Environment.MARIO_KEY_RIGHT] ? 1 : -1;

        for (int i = colItr; i != colItr*searchDistance; i+=colItr) {
            boolean enemyAhead = BehaviorTreeAgent.blackboard.getEnemiesCellValue(row, col + i) != 0;
            if (enemyAhead) {
                return true;
            }
        }

        return false;
    }
}
