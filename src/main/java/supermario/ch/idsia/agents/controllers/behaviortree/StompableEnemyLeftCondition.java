package supermario.ch.idsia.agents.controllers.behaviortree;

import supermario.ch.idsia.benchmark.mario.engine.sprites.Sprite;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="stompableenemyleft")
public class StompableEnemyLeftCondition implements TreeTask {

    @XmlAttribute(name="distance")
    private int searchDistance;

    @Override
    public boolean run() {
        int row = BehaviorTreeAgent.blackboard.getMarioEgoPosRow();
        int col = BehaviorTreeAgent.blackboard.getMarioEgoPosCol();

        for (int i = 1; i <= searchDistance; i++) {
            int spriteLeft = BehaviorTreeAgent.blackboard.getEnemiesCellValue(row, col-i);
            if (Sprite.isStompableCreatureSprite(spriteLeft)) {
                return true;
            }
        }

        return false;
    }
}
