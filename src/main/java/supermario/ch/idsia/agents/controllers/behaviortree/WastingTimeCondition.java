package supermario.ch.idsia.agents.controllers.behaviortree;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="wastingtime")
public class WastingTimeCondition implements TreeTask {

    @XmlAttribute(name="tolerance")
    private int timeTolerance;

    @Override
    public boolean run(GameStateDto gameStateDto) {
        int timeWasted = gameStateDto.environment.getTimeSpent() - gameStateDto.farthestProgressTimestamp;
        return timeWasted >= timeTolerance;
    }
}

