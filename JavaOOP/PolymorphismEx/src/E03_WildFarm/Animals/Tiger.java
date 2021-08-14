package E03_WildFarm.Animals;

import E03_WildFarm.Foods.Food;
import E03_WildFarm.Foods.Vegetable;

public class Tiger extends Felime {
    public Tiger(String name, String type, Double weight, String livingRegion) {
        super(name, type, weight, livingRegion);
    }

    @Override
    public void eat(Food food) {
        if(food instanceof Vegetable) {
            throw new IllegalArgumentException("Tigers are not eating that type of food!");
        }
        super.eat(food);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }
}
