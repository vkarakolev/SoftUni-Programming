package SpaceStation.repositories;

import SpaceStation.models.planets.Planet;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class PlanetRepository implements Repository<Planet> {
    private Map<String, Planet> planets;

    public PlanetRepository() {
        this.planets = new LinkedHashMap<>();
    }

    @Override
    public Collection<Planet> getModels() {
        return planets.values().stream().toList();
    }

    @Override
    public void add(Planet planet) {
        this.planets.putIfAbsent(planet.getName(), planet);
    }

    @Override
    public boolean remove(Planet planet) {
        return this.planets.remove(planet.getName(), planet);
    }

    @Override
    public Planet findByName(String name) {
        return this.planets.get(name);
    }
}
