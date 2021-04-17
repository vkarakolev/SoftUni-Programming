import java.util.Scanner;

public class Login_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();

        String correctPass = "";

        for (int i = username.length() - 1; i >= 0 ; i--) {
            correctPass += username.charAt(i);
        }

        int counter = 0;
        while (counter < 4){
            String password = scanner.nextLine();
            if(password.equals(correctPass)){
                System.out.printf("User %s logged in.", username);
                return;
            } else {
                counter++;
                if(counter == 4){
                    System.out.printf("User %s blocked!", username);
                } else {
                    System.out.println("Incorrect password. Try again.");
                }
            }
        }
    }
}
