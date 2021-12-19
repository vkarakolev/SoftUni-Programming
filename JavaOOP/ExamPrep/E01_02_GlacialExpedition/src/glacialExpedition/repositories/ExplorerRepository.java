package glacialExpedition.repositories;

import glacialExpedition.models.explorers.Explorer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ExplorerRepository implements Repository {
    private List<Explorer> explorers;

    public ExplorerRepository() {
        this.explorers = new ArrayList<>();
    }

    @Override
    public Collection<Explorer> getCollection() {
        return Collections.unmodifiableList(explorers);
    }

    @Override
    public void add(Object entity) {
        Explorer explorer = (Explorer) entity;

        if(!isExisting(explorers, explorer.getName())) {
            explorers.add(explorer);
        }
    }

    @Override
    public boolean remove(Object entity) {
        Explorer explorer = (Explorer) entity;

        if(explorers.contains(explorer)) {
            explorers.remove(explorer);
            return true;
        }
        return false;
    }

    @Override
    public Object byName(String name) {
        return explorers.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    private static boolean isExisting(List<Explorer> list, String name) {
        return list.stream()
                .anyMatch(e -> e.getName().equals(name));
    }
}
