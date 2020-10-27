package supermario.ch.idsia.agents.controllers.behaviortree;

import supermario.ch.idsia.benchmark.mario.environments.Environment;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="land")
public class LandAction implements TreeTask {
    @Override
    public boolean run(TaskDto taskDto) {
        taskDto.action[Environment.MARIO_KEY_JUMP] = false;
        return true;
    }
}
