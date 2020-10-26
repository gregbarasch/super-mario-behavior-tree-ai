package supermario.ch.idsia.agents.controllers.behaviortree;

import supermario.ch.idsia.benchmark.mario.environments.Environment;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="left")
public class LeftAction implements TreeTask {
    @Override
    public boolean run() {
        BehaviorTreeAgent.blackboard.action[Environment.MARIO_KEY_RIGHT] = false;
        BehaviorTreeAgent.blackboard.action[Environment.MARIO_KEY_LEFT] = true;
        return true;
    }
}
