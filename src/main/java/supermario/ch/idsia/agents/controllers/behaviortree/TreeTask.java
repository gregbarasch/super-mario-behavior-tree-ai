package supermario.ch.idsia.agents.controllers.behaviortree;

import supermario.ch.idsia.benchmark.mario.environments.Environment;

public interface TreeTask {
    boolean run(Environment environment, boolean[] action);
}
