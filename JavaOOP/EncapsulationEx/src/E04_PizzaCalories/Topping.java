package E04_PizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        if(!toppingType.equals("Meat")
                && !toppingType.equals("Veggies")
                && !toppingType.equals("Cheese")
                && !toppingType.equals("Sauce")) {
            throw new IllegalArgumentException("Cannot place " + toppingType + " on top of your pizza.");
        }
        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        if(weight < 0 || weight > 50) {
            throw new IllegalArgumentException(this.toppingType + " weight should be in the range [1..50].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {


        return (2 * weight) * getModifier();
    }

    private double getModifier() {
        double modifier = 0;

        switch (this.toppingType) {
            case "Meat" -> modifier = 1.2;
            case "Veggies" -> modifier = 0.8;
            case "Cheese" -> modifier = 1.1;
            case "Sauce" -> modifier = 0.9;
        }

        return modifier;
    }
}
