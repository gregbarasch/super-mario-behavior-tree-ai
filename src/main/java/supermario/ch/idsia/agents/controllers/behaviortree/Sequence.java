package supermario.ch.idsia.agents.controllers.behaviortree;

import supermario.ch.idsia.benchmark.mario.environments.Environment;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Sequence implements TreeTask {

    @XmlAnyElement(lax=true)
    private TreeTask[] children;

    @Override
    public boolean run(Environment environment, boolean[] action) {
        for (TreeTask child : children) {
            if (!child.run(environment, action)) {
                return false;
            }
        }
        return true;
    }
}
