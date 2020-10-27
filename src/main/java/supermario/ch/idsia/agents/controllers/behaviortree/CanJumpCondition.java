package supermario.ch.idsia.agents.controllers.behaviortree;

import supermario.ch.idsia.benchmark.mario.engine.sprites.Mario;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="canjump")
public class CanJumpCondition implements TreeTask {
    @Override
    public boolean run(TaskDto taskDto) {
        return taskDto.environment.isMarioAbleToJump()
                || (!taskDto.environment.isMarioOnGround() && taskDto.action[Mario.KEY_JUMP]);
    }
}
