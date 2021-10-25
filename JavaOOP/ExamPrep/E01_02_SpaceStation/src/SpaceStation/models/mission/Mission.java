package SpaceStation.models.mission;

import SpaceStation.models.astronauts.Astronaut;
import SpaceStation.models.planets.Planet;

import java.util.Collection;

public interface Mission {
    void explore(Planet planet, Collection<Astronaut> astronauts);
}
