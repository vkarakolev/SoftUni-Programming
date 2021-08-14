package E03_WildFarm.Animals;

import E03_WildFarm.Foods.Food;

public class Cat extends Felime {
    private String breed;

    public Cat(String name, String type, Double weight, String livingRegion, String breed) {
        super(name, type, weight, livingRegion);
        this.breed = breed;
    }

    @Override
    public String toString() {
        StringBuilder baseToString = new StringBuilder(super.toString());
        baseToString.insert(baseToString.indexOf(", ") + 2, this.breed + ", ");

        return baseToString.toString();
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }
}
