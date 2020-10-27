package supermario.ch.idsia.agents.controllers.behaviortree;

import supermario.ch.idsia.benchmark.mario.environments.Environment;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name="move")
public class MoveAction implements TreeTask {

    @XmlValue
    String direction;

    @Override
    public boolean run(TaskDto taskDto) {

        if ("reverse".equals(direction)) {
            taskDto.action[Environment.MARIO_KEY_RIGHT] = !taskDto.action[Environment.MARIO_KEY_RIGHT];
            taskDto.action[Environment.MARIO_KEY_LEFT] = !taskDto.action[Environment.MARIO_KEY_LEFT];
        } else if ("left".equals(direction)) {
            taskDto.action[Environment.MARIO_KEY_RIGHT] = false;
            taskDto.action[Environment.MARIO_KEY_LEFT] = true;
        } else {
            taskDto.action[Environment.MARIO_KEY_RIGHT] = true;
            taskDto.action[Environment.MARIO_KEY_LEFT] = false;
        }

        return true;
    }
}
