package supermario.ch.idsia.agents.controllers.behaviortree;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import static supermario.ch.idsia.agents.controllers.behaviortree.BehaviorTree.blackboard;

@XmlRootElement(name="setmovementlock")
public class SetMovementSemaphoreAction implements TreeTask {

    @XmlAttribute(name="ticks")
    private int lockTicks;

    @Override
    public boolean run() {
        blackboard.put(BlackboardHelper.MOVEMENT_SEMAPHORE, lockTicks);
        return true;
    }
}
