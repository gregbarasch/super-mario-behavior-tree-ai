package supermario.ch.idsia.agents.controllers.behaviortree;

import java.util.HashMap;

public class Blackboard {

    private final HashMap<String, Object> data = new HashMap<>();

    public Object get(String s) {
        return data.get(s);
    }

    public void put(String s, Object o) {
        data.put(s, o);
    }
}
