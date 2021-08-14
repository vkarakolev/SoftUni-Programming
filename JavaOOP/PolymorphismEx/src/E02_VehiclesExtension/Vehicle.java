package E02_VehiclesExtension;

import java.text.DecimalFormat;
import java.util.function.Supplier;

public class Vehicle {
    private double fuel;
    private double consumption;
    private double capacity;

    protected Vehicle(double fuel, double consumption, double capacity) {
        this.capacity = capacity;
        this.setFuel(fuel);
        this.consumption = consumption;
    }

    private void setFuel(double fuel) {
        validateNonNegativeFuel(fuel);
        validateHasEnoughFreeTankCapacity(fuel);
        this.fuel = fuel;
    }

    private void validateNonNegativeFuel(double fuel) {
        if (fuel <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
    }

    private void validateHasEnoughFreeTankCapacity(double additionalFuel) {
        if(additionalFuel > this.capacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
    }

    public String drive(double distance) {
        double fuelNeeded = distance * this.consumption;

        if(fuelNeeded > this.capacity - this.fuel) {
            return this.getClass().getSimpleName() + " needs refueling";
        }

        this.setFuel(this.fuel - fuelNeeded);

        DecimalFormat formatter = new DecimalFormat("##.##");

        return String.format("%s travelled %s km",this.getClass().getSimpleName(),
                formatter.format(distance));
    }

    public void refuel(double liters) {
        validateNonNegativeFuel(liters);
        validateHasEnoughFreeTankCapacity(liters);
        this.setFuel(this.fuel + liters);
    }

    protected <T> T doWithIncreasedConsumption(double additionalConsumption, Supplier<T> supplier) {
        this.consumption += additionalConsumption;
        try {
            return supplier.get();
        } catch (Throwable ex) {
            throw new IllegalStateException(ex);
        } finally {
            this.consumption -= additionalConsumption;
        }
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuel);
    }
}
