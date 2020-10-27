package supermario.ch.idsia.agents.controllers.behaviortree;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="decrementmovementlock")
public class DecrementMovementSemaphoreAction implements TreeTask {
    @Override
    public boolean run(GameStateDto gameStateDto) {
        gameStateDto.movementSemaphore--;
        return true;
    }
}
