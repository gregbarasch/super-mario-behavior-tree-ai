package supermario.ch.idsia.agents.controllers.behaviortree;

import supermario.ch.idsia.benchmark.mario.engine.sprites.Mario;
import supermario.ch.idsia.benchmark.mario.environments.Environment;

import javax.xml.bind.annotation.XmlRootElement;

import static supermario.ch.idsia.agents.controllers.behaviortree.BehaviorTree.*;

@XmlRootElement(name="canjump")
public class CanJumpCondition implements TreeTask {
    @Override
    public boolean run() {
        Environment environment = BlackboardHelper.getEnvironment(blackboard);
        boolean[] action = BlackboardHelper.getAction(blackboard);
        return environment.isMarioAbleToJump()
                || (!environment.isMarioOnGround() && action[Mario.KEY_JUMP]);
    }
}
