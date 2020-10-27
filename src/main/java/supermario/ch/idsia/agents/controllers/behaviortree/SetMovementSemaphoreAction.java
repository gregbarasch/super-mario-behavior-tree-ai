package supermario.ch.idsia.agents.controllers.behaviortree;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="setmovementlock")
public class SetMovementSemaphoreAction implements TreeTask {

    @XmlAttribute(name="ticks")
    private int lockTicks;

    @Override
    public boolean run(TaskDto taskDto) {
        taskDto.movementSemaphore = lockTicks;
        return true;
    }
}
