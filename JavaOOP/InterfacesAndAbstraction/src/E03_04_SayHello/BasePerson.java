package E03_04_SayHello;

public abstract class BasePerson implements Person {

    private String name;

    public BasePerson(String name) {
        setName(name);
    }

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

}
