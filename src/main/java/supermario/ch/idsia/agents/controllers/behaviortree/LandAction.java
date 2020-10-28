package supermario.ch.idsia.agents.controllers.behaviortree;

import supermario.ch.idsia.benchmark.mario.environments.Environment;

import javax.xml.bind.annotation.XmlRootElement;

import static supermario.ch.idsia.agents.controllers.behaviortree.BehaviorTree.blackboard;

@XmlRootElement(name="land")
public class LandAction implements TreeTask {
    @Override
    public boolean run() {
        BehaviorTree.BlackboardHelper.getAction(blackboard)[Environment.MARIO_KEY_JUMP] = false;
        return true;
    }
}
