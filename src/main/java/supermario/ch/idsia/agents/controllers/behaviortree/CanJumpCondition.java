package supermario.ch.idsia.agents.controllers.behaviortree;

import supermario.ch.idsia.benchmark.mario.engine.sprites.Mario;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="canjump")
public class CanJumpCondition implements TreeTask {
    @Override
    public boolean run(Blackboard blackboard) {
        return blackboard.environment.isMarioAbleToJump()
                || (!blackboard.environment.isMarioOnGround() && blackboard.action[Mario.KEY_JUMP]);
    }
}
