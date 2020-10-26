package supermario.ch.idsia.agents.controllers.behaviortree;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="wastingtime")
public class WastingTimeCondition implements TreeTask {

    @XmlAttribute(name="tolerance")
    private int timeTolerance;

    @Override
    public boolean run() {
        int timeWasted = BehaviorTreeAgent.blackboard.environment.getTimeSpent() - BehaviorTreeAgent.blackboard.farthestProgressTimestamp;
        return timeWasted >= timeTolerance;
    }
}
