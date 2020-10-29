package supermario.ch.idsia.agents.controllers.behaviortree;

import javax.xml.bind.annotation.XmlRootElement;

import static supermario.ch.idsia.agents.controllers.behaviortree.BehaviorTree.blackboard;

@XmlRootElement(name="movementlocked")
public class MovementLockedCondition implements TreeTask {
    @Override
    public boolean run() {
        return BlackboardHelper.getMovementSemaphore(blackboard) > 0;
    }
}
