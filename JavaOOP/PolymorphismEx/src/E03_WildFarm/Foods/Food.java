package E03_WildFarm.Foods;

public abstract class Food {
    private int quantity;

    protected Food(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
