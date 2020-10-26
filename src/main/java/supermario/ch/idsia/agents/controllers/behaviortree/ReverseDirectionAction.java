package supermario.ch.idsia.agents.controllers.behaviortree;

import supermario.ch.idsia.benchmark.mario.environments.Environment;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="reversedirection")
public class ReverseDirectionAction implements TreeTask {
    @Override
    public boolean run() {
        BehaviorTreeAgent.blackboard.action[Environment.MARIO_KEY_RIGHT] = !BehaviorTreeAgent.blackboard.action[Environment.MARIO_KEY_RIGHT];
        BehaviorTreeAgent.blackboard.action[Environment.MARIO_KEY_LEFT] = !BehaviorTreeAgent.blackboard.action[Environment.MARIO_KEY_LEFT];
        return true;
    }
}
