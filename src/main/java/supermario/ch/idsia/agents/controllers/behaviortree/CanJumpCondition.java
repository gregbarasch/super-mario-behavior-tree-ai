package supermario.ch.idsia.agents.controllers.behaviortree;

import supermario.ch.idsia.benchmark.mario.engine.sprites.Mario;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="canjump")
public class CanJumpCondition implements TreeTask {
    @Override
    public boolean run() {
        return BehaviorTreeAgent.blackboard.environment.isMarioAbleToJump()
                || (!BehaviorTreeAgent.blackboard.environment.isMarioOnGround() && BehaviorTreeAgent.blackboard.action[Mario.KEY_JUMP]);
    }
}
