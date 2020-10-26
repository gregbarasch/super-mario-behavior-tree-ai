package supermario.ch.idsia.agents.controllers.behaviortree;

import supermario.ch.idsia.benchmark.mario.environments.Environment;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="isjumpfinished")
public class DoneJumpingCondition implements TreeTask {
    @Override
    public boolean run(Environment environment, boolean[] action) {
        return environment.isMarioOnGround() && action[Environment.MARIO_KEY_JUMP];
    }
}
