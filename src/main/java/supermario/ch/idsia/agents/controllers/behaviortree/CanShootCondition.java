package supermario.ch.idsia.agents.controllers.behaviortree;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="canshoot")
public class CanShootCondition implements TreeTask {
    @Override
    public boolean run(TaskDto taskDto) {
        return taskDto.environment.isMarioAbleToShoot();
    }
}
