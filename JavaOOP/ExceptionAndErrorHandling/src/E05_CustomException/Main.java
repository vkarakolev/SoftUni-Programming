package E05_CustomException;

public class Main {
    public static void main(String[] args) {
        try {
            Student student = new Student("4avdar", "test@test.com");
        } catch (InvalidPersonNameException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
