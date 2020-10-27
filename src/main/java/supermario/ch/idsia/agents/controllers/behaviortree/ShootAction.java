package supermario.ch.idsia.agents.controllers.behaviortree;

import supermario.ch.idsia.benchmark.mario.environments.Environment;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="shoot")
public class ShootAction implements TreeTask {
    @Override
    public boolean run(Blackboard blackboard) {
        blackboard.action[Environment.MARIO_KEY_SPEED] = true;
        return true;
    }
}
