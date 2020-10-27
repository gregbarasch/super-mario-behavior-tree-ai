package supermario.ch.idsia.agents.controllers.behaviortree;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="movementlocked")
public class MovementLockedCondition implements TreeTask {
    @Override
    public boolean run(TaskDto taskDto) {
        return taskDto.movementSemaphore > 0;
    }
}
