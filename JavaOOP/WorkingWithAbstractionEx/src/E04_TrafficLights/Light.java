package E04_TrafficLights;

public enum Light {
    RED,
    GREEN,
    YELLOW;

    public static Light changeLight (Light light) {
        switch (light) {
            case RED : return GREEN;
            case GREEN : return YELLOW;
            case YELLOW : return RED;
            default : throw new IllegalArgumentException("Unknown color.");
        }
    }
}
