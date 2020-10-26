package supermario.ch.idsia.agents.controllers.behaviortree;

import supermario.ch.idsia.benchmark.mario.engine.sprites.Mario;
import supermario.ch.idsia.benchmark.mario.environments.Environment;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="shoot")
public class ShootAction implements TreeTask {
    @Override
    public boolean run(Environment environment, boolean[] action) {
        action[Environment.MARIO_KEY_SPEED] = true;
        return true;
    }
}
