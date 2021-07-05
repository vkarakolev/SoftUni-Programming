package E04_TrafficLights;

public enum Light {
    RED,
    GREEN,
    YELLOW;

    public Light changeLight (Light light) {
        switch (light) {
            case RED -> {return GREEN;}
            case GREEN -> {return YELLOW;}
            case YELLOW -> {return RED;}
        }
    }
}
