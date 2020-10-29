package supermario.ch.idsia.agents.controllers.behaviortree;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import static supermario.ch.idsia.agents.controllers.behaviortree.BehaviorTree.blackboard;

@XmlRootElement(name="wastingtime")
public class WastingTimeCondition implements TreeTask {

    @XmlAttribute(name="tolerance")
    private int timeTolerance;

    @Override
    public boolean run() {
        int timeWasted = BlackboardHelper.getEnvironment(blackboard).getTimeSpent() - BlackboardHelper.getFarthestProgressTimetamp(blackboard);
        return timeWasted >= timeTolerance;
    }
}

