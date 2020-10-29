package supermario.ch.idsia.agents.controllers.behaviortree;

import javax.xml.bind.annotation.XmlRootElement;

import static supermario.ch.idsia.agents.controllers.behaviortree.BehaviorTree.blackboard;

@XmlRootElement(name="decrementmovementlock")
public class DecrementMovementSemaphoreAction implements TreeTask {
    @Override
    public boolean run() {
        BlackboardHelper.decrementMovementSempahore(blackboard);
        return true;
    }
}
