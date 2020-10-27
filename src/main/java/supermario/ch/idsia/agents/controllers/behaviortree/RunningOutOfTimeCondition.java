package supermario.ch.idsia.agents.controllers.behaviortree;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="timerunningout")
public class RunningOutOfTimeCondition implements TreeTask {

    @XmlAttribute(name="tolerance")
    private int timeTolerance;

    @Override
    public boolean run(TaskDto taskDto) {
        return taskDto.environment.getTimeLeft() <= timeTolerance;
    }
}
