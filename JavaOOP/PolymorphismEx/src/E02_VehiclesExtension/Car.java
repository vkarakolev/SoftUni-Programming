package E02_VehiclesExtension;

public class Car extends Vehicle {
    private static final double AIR_CONDITIONER_ADDITIONAL_CONSUMPTION = 0.9;

    protected Car(double fuel, double consumption, double capacity) {
        super(fuel, consumption + AIR_CONDITIONER_ADDITIONAL_CONSUMPTION, capacity);
    }
}
