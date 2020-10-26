package supermario.ch.idsia.agents.controllers.behaviortree;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="setmovementlock")
public class SetMovementSemaphoreAction implements TreeTask {
    public static final int LOCK_TICKS = 20;

    @Override
    public boolean run() {
        BehaviorTreeAgent.blackboard.movementSemaphore = LOCK_TICKS;
        return true;
    }
}
