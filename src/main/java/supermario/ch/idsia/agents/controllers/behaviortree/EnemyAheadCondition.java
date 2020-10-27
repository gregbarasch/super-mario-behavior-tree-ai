package supermario.ch.idsia.agents.controllers.behaviortree;

import supermario.ch.idsia.benchmark.mario.engine.sprites.Sprite;
import supermario.ch.idsia.benchmark.mario.environments.Environment;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="enemyahead")
public class EnemyAheadCondition implements TreeTask {

    @XmlAttribute(name="ahead")
    private int aheadDistance;

    @XmlAttribute(name="down")
    private int downDistance;

    @XmlAttribute(name="up")
    private int upDistance;

    @XmlAttribute
    private boolean stompable;

    @Override
    public boolean run() {
        int row = BehaviorTreeAgent.blackboard.getMarioEgoPosRow();
        int col = BehaviorTreeAgent.blackboard.getMarioEgoPosCol();
        int colItr = BehaviorTreeAgent.blackboard.action[Environment.MARIO_KEY_RIGHT] ? 1 : -1;

        for (int i = colItr; i-colItr != colItr*aheadDistance; i+=colItr) {

            for (int j = 0; j <= upDistance; j++) {
                int sprite = BehaviorTreeAgent.blackboard.getEnemiesCellValue(row-j, col+i);
                if (isEnemyOfInterest(sprite)) return true;
            }

            for (int j = 0; j <= downDistance; j++) {
                int sprite = BehaviorTreeAgent.blackboard.getEnemiesCellValue(row+j, col+i);
                if (isEnemyOfInterest(sprite)) return true;
            }
        }

        return false;
    }

    private boolean isEnemyOfInterest(int sprite) {
        if (stompable) return Sprite.isStompableCreatureSprite(sprite);
        return Sprite.isCreatureSprite(sprite);
    }
}
