package SpaceStation.models.mission;

import SpaceStation.models.astronauts.Astronaut;
import SpaceStation.models.planets.Planet;

import java.util.Collection;

public class MissionImpl implements Mission {
    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {
        for (Astronaut a : astronauts) {
            while (a.canBreath()) {
                String currentItem = planet.getItems().stream().findFirst().orElseThrow();
                a.getBag().getItems().add(currentItem);
                planet.getItems().remove(currentItem);
                a.breath();
            }
        }
    }
}
