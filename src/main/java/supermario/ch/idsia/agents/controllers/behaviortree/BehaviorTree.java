package supermario.ch.idsia.agents.controllers.behaviortree;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class BehaviorTree {

    protected static Blackboard blackboard = new Blackboard();
    private final TreeTask root;

    public BehaviorTree(String btXml) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(
                Selector.class, Sequence.class,

                CanJumpCondition.class, DoneJumpingCondition.class, CanShootCondition.class, EnemyAheadCondition.class,
                EnemyNearCondition.class, CoinAheadCondition.class, CoinNearCondition.class, MovementLockedCondition.class,
                WallAheadCondition.class, GapAheadCondition.class, WastingTimeCondition.class, RunningOutOfTimeCondition.class,

                JumpAction.class, LandAction.class, MoveAction.class, ShootAction.class, ShootCompleteAction.class,
                DecrementMovementSemaphoreAction.class, SetMovementSemaphoreAction.class
        );

        Unmarshaller unmarshaller = context.createUnmarshaller();

        this.root = (TreeTask) unmarshaller.unmarshal(new File(btXml));
    }

    public void run() {
        root.run();
    }

    public Blackboard getBlackboard() {
        return blackboard;
    }

    public void resetBlackboard() {
        blackboard = new Blackboard();
    }
}
