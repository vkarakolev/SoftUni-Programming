package E03_WildFarm.Animals;

import E03_WildFarm.Foods.Food;
import E03_WildFarm.Foods.Meat;

public class Zebra extends Mammal {

    public Zebra(String name, String type, Double weight, String livingRegion) {
        super(name, type, weight, livingRegion);
    }

    @Override
    public void eat(Food food) {
        if(food instanceof Meat) {
            throw new IllegalArgumentException("Zebras are not eating that type of food!");
        }
        super.eat(food);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }
}
