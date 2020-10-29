package supermario.ch.idsia.agents.controllers.behaviortree;

import supermario.ch.idsia.benchmark.mario.environments.Environment;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

import static supermario.ch.idsia.agents.controllers.behaviortree.BehaviorTree.blackboard;

@XmlRootElement(name="move")
public class MoveAction implements TreeTask {

    @XmlValue
    String direction;

    @Override
    public boolean run() {
        boolean[] action = BlackboardHelper.getAction(blackboard);
        if ("reverse".equals(direction)) {
            action[Environment.MARIO_KEY_RIGHT] = !action[Environment.MARIO_KEY_RIGHT];
            action[Environment.MARIO_KEY_LEFT] = !action[Environment.MARIO_KEY_LEFT];
        } else if ("left".equals(direction)) {
            action[Environment.MARIO_KEY_RIGHT] = false;
            action[Environment.MARIO_KEY_LEFT] = true;
        } else {
            action[Environment.MARIO_KEY_RIGHT] = true;
            action[Environment.MARIO_KEY_LEFT] = false;
        }

        return true;
    }
}
