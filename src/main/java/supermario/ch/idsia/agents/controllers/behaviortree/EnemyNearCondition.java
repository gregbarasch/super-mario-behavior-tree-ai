package supermario.ch.idsia.agents.controllers.behaviortree;

import supermario.ch.idsia.benchmark.mario.engine.sprites.Sprite;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import static supermario.ch.idsia.agents.controllers.behaviortree.BehaviorTree.blackboard;

@XmlRootElement(name="enemynear")
public class EnemyNearCondition implements TreeTask {

    @XmlAttribute(name="left")
    private int leftDistance;

    @XmlAttribute(name="right")
    private int rightDistance;

    @XmlAttribute(name="down")
    private int downDistance;

    @XmlAttribute(name="up")
    private int upDistance;

    @XmlAttribute
    private boolean stompable;

    @Override
    public boolean run() {
        int row = BlackboardHelper.getMarioEgoPosRow(blackboard);
        int col = BlackboardHelper.getMarioEgoPosCol(blackboard);

        for (int i = 0; i <= leftDistance; i++) {
            for (int j = 0; j <= upDistance; j++) {
                int sprite = BlackboardHelper.getEnemiesCellValue(blackboard, row+j, col-i);
                if (isEnemyOfInterest(sprite)) return true;
            }

            for (int j = 0; j <= downDistance; j++) {
                int sprite = BlackboardHelper.getEnemiesCellValue(blackboard, row-j, col-i);
                if (isEnemyOfInterest(sprite)) return true;
            }
        }

        for (int i = 0; i <= rightDistance; i++) {

            for (int j = 0; j <= upDistance; j++) {
                int sprite = BlackboardHelper.getEnemiesCellValue(blackboard,row-j, col+i);
                if (isEnemyOfInterest(sprite)) return true;

            }

            for (int j = 1; j <= downDistance; j++) {
                int sprite = BlackboardHelper.getEnemiesCellValue(blackboard, row+j, col+i);
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
