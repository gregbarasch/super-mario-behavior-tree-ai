package supermario.ch.idsia.agents.controllers.behaviortree;

import supermario.ch.idsia.benchmark.mario.environments.Environment;

import javax.xml.bind.annotation.XmlRootElement;

import static supermario.ch.idsia.agents.controllers.behaviortree.BehaviorTree.*;

@XmlRootElement(name="canshoot")
public class CanShootCondition implements TreeTask {
    @Override
    public boolean run() {
        Environment environment = BlackboardHelper.getEnvironment(blackboard);
        return environment.isMarioAbleToShoot();
    }
}
