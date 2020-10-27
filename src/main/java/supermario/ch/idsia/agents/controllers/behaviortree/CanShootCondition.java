package supermario.ch.idsia.agents.controllers.behaviortree;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="canshoot")
public class CanShootCondition implements TreeTask {
    @Override
    public boolean run(GameStateDto gameStateDto) {
        return gameStateDto.environment.isMarioAbleToShoot();
    }
}
