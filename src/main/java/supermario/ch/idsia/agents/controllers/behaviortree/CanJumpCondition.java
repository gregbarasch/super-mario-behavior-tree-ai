package supermario.ch.idsia.agents.controllers.behaviortree;

import supermario.ch.idsia.benchmark.mario.engine.sprites.Mario;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="canjump")
public class CanJumpCondition implements TreeTask {
    @Override
    public boolean run(GameStateDto gameStateDto) {
        return gameStateDto.environment.isMarioAbleToJump()
                || (!gameStateDto.environment.isMarioOnGround() && gameStateDto.action[Mario.KEY_JUMP]);
    }
}
