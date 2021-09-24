package aquarium.entities.decorations;

public class Ornament extends BaseDecoration {
    private static final int COMFORT = 1;
    private static final double PRICE = 5;

    public Ornament() {
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
