package supermario.ch.idsia.agents.controllers.behaviortree;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Selector implements TreeTask {

    @XmlAnyElement(lax=true)
    private TreeTask[] children;

    @Override
    public boolean run(GameStateDto gameStateDto) {
        for (TreeTask child : children) {
            if (child.run(gameStateDto)) {
                return true;
            }
        }
        return false;
    }
}
