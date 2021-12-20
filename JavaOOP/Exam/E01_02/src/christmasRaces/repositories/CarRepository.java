package christmasRaces.repositories;

import christmasRaces.entities.cars.Car;
import christmasRaces.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CarRepository implements Repository<Car> {
    List<Car> models;

    public CarRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Car getByName(String name) {
        return models.stream()
                .filter(m -> m.getModel().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Collection getAll() {
        return Collections.unmodifiableList(models);
    }

    @Override
    public void add(Car model) {
        models.add(model);
    }

    @Override
    public boolean remove(Car model) {
        return models.remove(model);
    }

}
