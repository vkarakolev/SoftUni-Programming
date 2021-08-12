package E04_FoodShortage;

public class Citizen extends AbstractCitizen implements Identifiable {
    private String id;
    private String birthDate;

    public Citizen(String name, int age, String id, String birthDate) {
        super(name, age);
        this.id = id;
        this.birthDate = birthDate;
    }

    public String getBirthDate() {
        return birthDate;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void buyFood() {
        super.addFood(10);
    }
}
