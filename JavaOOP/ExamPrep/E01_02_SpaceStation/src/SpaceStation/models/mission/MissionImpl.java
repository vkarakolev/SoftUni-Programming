package SpaceStation.models.mission;

import SpaceStation.models.astronauts.Astronaut;
import SpaceStation.models.planets.Planet;

import java.util.Collection;

public class MissionImpl implements Mission {
    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {
            Collection<String> items = planet.getItems();
            while (!items.isEmpty()) {
                if(astronauts.isEmpty()) {
                    break;
                }

                Astronaut currentAstronaut = astronauts.stream().findFirst().orElseThrow();
                String currentItem = items.stream().findFirst().orElseThrow();
                currentAstronaut.getBag().getItems().add(currentItem);
                items.remove(currentItem);
                currentAstronaut.breath();

                if(!currentAstronaut.canBreath()) {
                    astronauts.remove(currentAstronaut);
                }
            }

//            for (int i = 0; i < items.size(); i++) {
//                a.getBag().getItems().add(items.get(0));
//                items.remove(items.get(0));
//                a.breath();
//
//                if(!a.canBreath()) {
//                    astronauts.remove(a);
//                }
//            }
    }
}
