package E03_WildFarm.Animals;

import E03_WildFarm.Foods.Food;

import java.text.DecimalFormat;

public abstract class Animal {
    private String name;
    private String type;
    private Double weight;
    private String livingRegion;
    private Integer foodEaten;

    protected Animal(String name, String type, Double weight, String livingRegion) {
        this.name = name;
        this.type = type;
        this.weight = weight;
        this.livingRegion = livingRegion;
        this.foodEaten = 0;
    }

    protected String getType() {
        return type;
    }

    public abstract void makeSound();

    public void eat(Food food) {
        this.foodEaten += food.getQuantity();
    }

    @Override
    public String toString() {
        DecimalFormat formatter = new DecimalFormat("##.##");
        return String.format("%s[%s, %s, %s, %d]",
               this.type, this.name,formatter.format(this.weight), this.livingRegion, this.foodEaten);
    }
}
