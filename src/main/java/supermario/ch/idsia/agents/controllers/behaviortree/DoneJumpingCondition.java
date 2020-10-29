package supermario.ch.idsia.agents.controllers.behaviortree;

import supermario.ch.idsia.benchmark.mario.environments.Environment;

import javax.xml.bind.annotation.XmlRootElement;

import static supermario.ch.idsia.agents.controllers.behaviortree.BehaviorTree.blackboard;

@XmlRootElement(name="isjumpfinished")
public class DoneJumpingCondition implements TreeTask {
    @Override
    public boolean run() {
        Environment environment =  BlackboardHelper.getEnvironment(blackboard);
        boolean[] action = BlackboardHelper.getAction(blackboard);
        return environment.isMarioOnGround() && action[Environment.MARIO_KEY_JUMP];
    }
}
