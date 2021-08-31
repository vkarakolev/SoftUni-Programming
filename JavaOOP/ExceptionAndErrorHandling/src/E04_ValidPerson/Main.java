package E04_ValidPerson;

public class Main {
    public static void main(String[] args) {
        try {
            Person person = new Person("Name", "LastName", 20);
            Person noName = new Person(" ", "LastName", 20);
            Person noLastName = new Person("Name", null, 20);
            Person negativeAge = new Person("Name", "LastName", -1);
            Person tooOld = new Person("Name", "LastName", 121);
        } catch (IllegalArgumentException ex) {
            System.out.println("Exception thrown: " + ex.getMessage());
        }
    }
}
