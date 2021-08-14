package E02_VehiclesExtension;

public class Bus extends Vehicle {
    private static final double AIR_CONDITIONER_ADDITIONAL_CONSUMPTION = 1.4;

    protected Bus(double fuel, double consumption, double capacity) {
        super(fuel, consumption, capacity);
    }

    public String driveWithPassengers(double distance) {
        return super.doWithIncreasedConsumption(AIR_CONDITIONER_ADDITIONAL_CONSUMPTION,
                () -> super.drive(distance));

    }
}
