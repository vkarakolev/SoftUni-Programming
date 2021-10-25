package SpaceStation.repositories;

import SpaceStation.models.astronauts.Astronaut;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class AstronautRepository implements Repository<Astronaut> {
    private Map<String, Astronaut> astronauts;

    public AstronautRepository() {
        this.astronauts = new LinkedHashMap<>();
    }

    @Override
    public Collection<Astronaut> getModels() {
        return astronauts.values().stream().toList();
    }

    @Override
    public void add(Astronaut astronaut) {
        this.astronauts.putIfAbsent(astronaut.getName(), astronaut);
    }

    @Override
    public boolean remove(Astronaut astronaut) {
        return this.astronauts.remove(astronaut.getName(), astronaut);
    }

    @Override
    public Astronaut findByName(String name) {
        return this.astronauts.get(name);
    }
}
