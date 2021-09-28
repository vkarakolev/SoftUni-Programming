package aquarium.entities.fish;

public abstract class BaseFish implements Fish {

    private String name;
    private String species;
    private int size;
    private double price;

    protected BaseFish(String name, String species, double price) {

    }

    @Override
    public void setName(String name) {

    }

    @Override
    public void eat() {

    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public double getPrice() {
        return 0;
    }
}
