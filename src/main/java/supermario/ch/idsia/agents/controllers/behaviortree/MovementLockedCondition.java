package supermario.ch.idsia.agents.controllers.behaviortree;

import javax.xml.bind.annotation.XmlRootElement;

import static supermario.ch.idsia.benchmark.mario.engine.GeneralizerLevelScene.COIN_ANIM;

@XmlRootElement(name="movementlocked")
public class MovementLockedCondition implements TreeTask {

    @Override
    public boolean run() {
        return BehaviorTreeAgent.blackboard.movementSemaphore > 0;
    }
}
