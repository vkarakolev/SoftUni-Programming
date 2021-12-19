package glacialExpedition.repositories;

import glacialExpedition.models.states.State;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class StateRepository implements Repository {
    private List<State> states;

    public StateRepository() {
        this.states = new ArrayList<>();
    }

    @Override
    public Collection<State> getCollection() {
        return Collections.unmodifiableList(states);
    }

    @Override
    public void add(Object entity) {
        State state = (State) entity;

        if(!isExisting(states, state.getName())) {
            states.add(state);
        }
    }

    @Override
    public boolean remove(Object entity) {
        State state = (State) states;

        if(states.contains(state)) {
            states.remove(state);
            return true;
        }
        return false;
    }

    @Override
    public Object byName(String name) {
        return states.stream()
                .filter(s -> s.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    private static boolean isExisting(List<State> list, String name) {
        return list.stream()
                .anyMatch(s -> s.getName().equals(name));
    }
}
