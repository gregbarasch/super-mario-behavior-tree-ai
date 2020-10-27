package supermario.ch.idsia.agents.controllers.behaviortree;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="setmovementlock")
public class SetMovementSemaphoreAction implements TreeTask {

    @XmlAttribute(name="ticks")
    private int lockTicks;

    @Override
    public boolean run(Blackboard blackboard) {
        blackboard.movementSemaphore = lockTicks;
        return true;
    }
}
