package aquarium.entities.decorations;

public class Plant extends BaseDecoration {
    private static final int COMFORT = 5;
    private static final double PRICE = 10;

    public Plant() {
        super(COMFORT, PRICE);
    }

    @Override
    public int getComfort() {
        return COMFORT;
    }

    @Override
    public double getPrice() {
        return PRICE;
    }
}
