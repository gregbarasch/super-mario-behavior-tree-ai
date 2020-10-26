package supermario.ch.idsia.agents.controllers.behaviortree;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import static supermario.ch.idsia.benchmark.mario.engine.GeneralizerLevelScene.COIN_ANIM;

@XmlRootElement(name="coinleft")
public class CoinLeftCondition implements TreeTask {

    @XmlAttribute(name="distance")
    private int searchDistance;

    @Override
    public boolean run() {
        int row = BehaviorTreeAgent.blackboard.getMarioEgoPosRow();
        int col = BehaviorTreeAgent.blackboard.getMarioEgoPosCol();

        for (int i = 1; i <= searchDistance; i++) {
            boolean coinBehind = BehaviorTreeAgent.blackboard.getReceptiveFieldCellValue(row, col-i) == COIN_ANIM;
            if (coinBehind) {
                return true;
            }
        }

        return false;
    }
}
