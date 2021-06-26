package groomingSalon;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class GroomingSalon {
    int capacity;
    List<Pet> data;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add (Pet pet) {
        if(data.size() < capacity) {
            data.add(pet);
        }
    }

    public int getCount () {
        return data.size();
    }

    public boolean remove(String name) {
        return data.removeIf(p -> p.getName().equals(name));
    }

    public Pet getPet(String name, String owner) {
        return data.stream()
                .filter(p -> p.getName().equals(name) && p.getOwner().equals(owner))
                .findFirst()
                .orElse(null);
    }

    public String getStatistics () {
        return String.format("The grooming salon has the following clients:%n%s",
                data.stream()
                        .map(p -> String.format("%s %s", p.getName(), p.getOwner()))
                        .collect(Collectors.joining(System.lineSeparator()))
        );
    }
}
