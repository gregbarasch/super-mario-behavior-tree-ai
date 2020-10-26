package supermario.ch.idsia.agents.controllers.behaviortree;

import supermario.ch.idsia.agents.Agent;
import supermario.ch.idsia.agents.controllers.BasicMarioAIAgent;
import supermario.ch.idsia.benchmark.mario.environments.Environment;

public class BehaviorTreeAgent extends BasicMarioAIAgent implements Agent {

    private final TreeTask root;
    private Environment environment;

    public BehaviorTreeAgent(String name, TreeTask root) {
        super("BehaviorTreeAgent - " + name);
        reset();

        this.root = root;
    }

    @Override
    public void reset() {
        action = new boolean[Environment.numberOfKeys];
    }

    @Override
    public boolean[] getAction() {
        root.run(environment, action);
        return action;
    }

    @Override
    public void integrateObservation(Environment environment) {
        this.environment = environment;
    }
}
