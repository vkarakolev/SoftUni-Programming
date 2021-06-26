package dealership;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Dealership {
    String name;
    int capacity;
    List<Car> data;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (data.size() < capacity) {
            data.add(car);
        }
    }

    public int getCount() {
        return data.size();
    }

    public boolean buy(String manufacturer, String model) {
        return data.removeIf(getCarPredicate(manufacturer, model));
    }

    private Predicate<Car> getCarPredicate(String manufacturer, String model) {
        return e -> e.getManufacturer().equals(manufacturer) && e.getModel().equals(model);
    }

    public Car getLatestCar() {
        return data.stream()
                .max(Comparator.comparingInt(Car::getYear))
                .orElse(null);
    }

    public  Car getCar(String manufacturer, String model) {
        return data.stream()
                .filter(getCarPredicate(manufacturer, model))
                .findFirst()
                .orElse(null);
    }

    public String getStatistics() {
        return String.format("The cars are in a car dealership %s:%n%s", name,
                data.stream()
                .map(Car::toString)
                .collect(Collectors.joining(System.lineSeparator())));
    }
}
