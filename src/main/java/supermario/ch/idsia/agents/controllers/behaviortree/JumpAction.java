package supermario.ch.idsia.agents.controllers.behaviortree;

import supermario.ch.idsia.benchmark.mario.environments.Environment;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="jump")
public class JumpAction implements TreeTask {
    @Override
    public boolean run() {
        BehaviorTreeAgent.blackboard.action[Environment.MARIO_KEY_JUMP] = true;
        return true;
    }
}
