package supermario.ch.idsia.agents.controllers.behaviortree;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Selector implements TreeTask {

    @XmlAnyElement(lax=true)
    private TreeTask[] children;

    @Override
    public boolean run(TaskDto taskDto) {
        for (TreeTask child : children) {
            if (child.run(taskDto)) {
                return true;
            }
        }
        return false;
    }
}
