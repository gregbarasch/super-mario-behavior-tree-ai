package supermario.ch.idsia.agents.controllers.behaviortree;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Selector implements TreeTask {

    @XmlAnyElement(lax=true)
    private TreeTask[] children;

    @Override
    public boolean run(Blackboard blackboard) {
        for (TreeTask child : children) {
            if (child.run(blackboard)) {
                return true;
            }
        }
        return false;
    }
}
