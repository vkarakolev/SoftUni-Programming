package christmasRaces.entities.cars;

import static christmasRaces.common.ExceptionMessages.INVALID_HORSE_POWER;

public class MuscleCar extends BaseCar {
    private static final double DEFAULT_CUBIC_CENTIMETERS = 5000;
    private static final int MIN_HP = 400;
    private static final int MAX_HP = 600;

    public MuscleCar(String model, int horsePower) {
        super(model, setHorsePower(horsePower), DEFAULT_CUBIC_CENTIMETERS);
    }

    private static int setHorsePower(int horsePower) {
        if(horsePower < MIN_HP || horsePower > MAX_HP) {
            throw new IllegalArgumentException(String.format(INVALID_HORSE_POWER, horsePower));
        }
        return horsePower;
    }
}
