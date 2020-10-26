package supermario.ch.idsia.agents.controllers.behaviortree;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="enemyleft")
public class EnemyLeftCondition implements TreeTask {

    @XmlAttribute(name="distance")
    private int searchDistance;

    @Override
    public boolean run() {
        int row = BehaviorTreeAgent.blackboard.getMarioEgoPosRow();
        int col = BehaviorTreeAgent.blackboard.getMarioEgoPosCol();

        for (int i = 1; i <= searchDistance; i++) {
            boolean enemyLeft = BehaviorTreeAgent.blackboard.getEnemiesCellValue(row, col-i) != 0;
            if (enemyLeft) {
                return true;
            }
        }

        return false;
    }
}
