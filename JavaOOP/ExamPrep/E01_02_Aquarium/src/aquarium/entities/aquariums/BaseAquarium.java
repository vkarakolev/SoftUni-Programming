package aquarium.entities.aquariums;

import aquarium.entities.decorations.Decoration;
import aquarium.entities.fish.Fish;

import java.util.Collection;

public abstract class BaseAquarium implements Aquarium {
    private String name;
    private int capacity;
    private Collection<Decoration> decorations;
    private Collection<Fish> fishCollection;

    protected BaseAquarium(String name, int capacity) {

    }

    @Override
    public int calculateComfort() {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void addFish(Fish fish) {

    }

    @Override
    public void removeFish(Fish fish) {

    }

    @Override
    public void addDecoration(Decoration decoration) {

    }

    @Override
    public void feed() {

    }

    @Override
    public String getInfo() {
        return null;
    }

    @Override
    public Collection<Fish> getFish() {
        return null;
    }

    @Override
    public Collection<Decoration> getDecorations() {
        return null;
    }
}
