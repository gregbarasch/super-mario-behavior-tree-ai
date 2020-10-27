package supermario.ch.idsia.agents.controllers.behaviortree;

import supermario.ch.idsia.benchmark.mario.environments.Environment;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name="move")
public class MoveAction implements TreeTask {

    @XmlValue
    String direction;

    @Override
    public boolean run(GameStateDto gameStateDto) {

        if ("reverse".equals(direction)) {
            gameStateDto.action[Environment.MARIO_KEY_RIGHT] = !gameStateDto.action[Environment.MARIO_KEY_RIGHT];
            gameStateDto.action[Environment.MARIO_KEY_LEFT] = !gameStateDto.action[Environment.MARIO_KEY_LEFT];
        } else if ("left".equals(direction)) {
            gameStateDto.action[Environment.MARIO_KEY_RIGHT] = false;
            gameStateDto.action[Environment.MARIO_KEY_LEFT] = true;
        } else {
            gameStateDto.action[Environment.MARIO_KEY_RIGHT] = true;
            gameStateDto.action[Environment.MARIO_KEY_LEFT] = false;
        }

        return true;
    }
}
