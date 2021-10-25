package SpaceStation.models.astronauts;

import SpaceStation.models.bags.Bag;

public interface Astronaut {
    String getName();

    double getOxygen();

    boolean canBreath();

    Bag getBag();

    void breath();
}
