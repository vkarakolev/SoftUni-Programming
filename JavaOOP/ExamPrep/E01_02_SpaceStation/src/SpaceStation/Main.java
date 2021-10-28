package SpaceStation;

import SpaceStation.core.ControllerImpl;
import SpaceStation.core.Engine;
import SpaceStation.core.EngineImpl;

public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl(new ControllerImpl());
        engine.run();
    }
}
