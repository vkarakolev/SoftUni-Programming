package E02_VehiclesExtension;

public class Truck extends Vehicle {
    private static final double AIR_CONDITIONER_ADDITIONAL_CONSUMPTION = 1.6;

    protected Truck(double fuel, double consumption, double capacity) {
        super(fuel, consumption + AIR_CONDITIONER_ADDITIONAL_CONSUMPTION, capacity);
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters * 0.95);
    }
}
