package supermario.ch.idsia.agents.controllers.behaviortree;

import supermario.ch.idsia.benchmark.mario.environments.Environment;

import javax.xml.bind.annotation.XmlRootElement;

import static supermario.ch.idsia.agents.controllers.behaviortree.BehaviorTree.blackboard;

@XmlRootElement(name="shoot")
public class ShootAction implements TreeTask {
    @Override
    public boolean run() {
        BlackboardHelper.getAction(blackboard)[Environment.MARIO_KEY_SPEED] = true;
        return true;
    }
}
