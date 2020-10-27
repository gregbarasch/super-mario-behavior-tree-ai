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
    public boolean run(Blackboard blackboard) {

        if ("reverse".equals(direction)) {
            blackboard.action[Environment.MARIO_KEY_RIGHT] = !blackboard.action[Environment.MARIO_KEY_RIGHT];
            blackboard.action[Environment.MARIO_KEY_LEFT] = !blackboard.action[Environment.MARIO_KEY_LEFT];
        } else if ("left".equals(direction)) {
            blackboard.action[Environment.MARIO_KEY_RIGHT] = false;
            blackboard.action[Environment.MARIO_KEY_LEFT] = true;
        } else {
            blackboard.action[Environment.MARIO_KEY_RIGHT] = true;
            blackboard.action[Environment.MARIO_KEY_LEFT] = false;
        }

        return true;
    }
}
