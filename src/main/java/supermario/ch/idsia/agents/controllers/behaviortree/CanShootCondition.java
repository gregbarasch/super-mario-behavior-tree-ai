package supermario.ch.idsia.agents.controllers.behaviortree;

import supermario.ch.idsia.benchmark.mario.engine.sprites.Mario;
import supermario.ch.idsia.benchmark.mario.environments.Environment;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="canshoot")
public class CanShootCondition implements TreeTask {
    @Override
    public boolean run(Blackboard blackboard) {
        return blackboard.environment.isMarioAbleToShoot();
    }
}
