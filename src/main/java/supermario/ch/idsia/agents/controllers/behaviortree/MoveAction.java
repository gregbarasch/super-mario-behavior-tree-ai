package supermario.ch.idsia.agents.controllers.behaviortree;

import supermario.ch.idsia.benchmark.mario.environments.Environment;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name="move")
public class MoveAction implements TreeTask {

    @XmlValue
    String direction;

    @Override
    public boolean run() {

        if ("reverse".equals(direction)) {
            BehaviorTreeAgent.blackboard.action[Environment.MARIO_KEY_RIGHT] = !BehaviorTreeAgent.blackboard.action[Environment.MARIO_KEY_RIGHT];
            BehaviorTreeAgent.blackboard.action[Environment.MARIO_KEY_LEFT] = !BehaviorTreeAgent.blackboard.action[Environment.MARIO_KEY_LEFT];
        } else if ("left".equals(direction)) {
            BehaviorTreeAgent.blackboard.action[Environment.MARIO_KEY_RIGHT] = false;
            BehaviorTreeAgent.blackboard.action[Environment.MARIO_KEY_LEFT] = true;
        } else {
            BehaviorTreeAgent.blackboard.action[Environment.MARIO_KEY_RIGHT] = true;
            BehaviorTreeAgent.blackboard.action[Environment.MARIO_KEY_LEFT] = false;
        }

        return true;
    }
}
