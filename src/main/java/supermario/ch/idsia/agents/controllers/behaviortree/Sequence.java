package supermario.ch.idsia.agents.controllers.behaviortree;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Sequence implements TreeTask {

    @XmlAnyElement(lax=true)
    private TreeTask[] children;

    @Override
    public boolean run() {
        for (TreeTask child : children) {
            if (!child.run()) {
                return false;
            }
        }
        return true;
    }
}
