package E04_FoodShortage;

public abstract class AbstractCitizen implements Person, Buyer {
    private String name;
    private int age;
    private int food;

    protected AbstractCitizen(String name, int age) {
        this.name = name;
        this.age = age;
        this.food = 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public int getFood() {
        return food;
    }

    protected void addFood(int addition) {
        this.food += addition;
    }

    @Override
    public abstract void buyFood();
}
