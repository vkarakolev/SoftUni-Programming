package E03_BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Birthable> birthables = new ArrayList<>();

        String line = scanner.nextLine();

        while (!line.equals("End")) {
            String[] tokens = line.split("\\s+");

            Birthable birthable = null;
            switch (tokens[0]) {
                case "Citizen":
                    birthable = new Citizen(tokens[1], Integer.parseInt(tokens[2]), tokens[3], tokens[4]);
                    break;
                case "Pet":
                    birthable = new Pet(tokens[1], tokens[2]);
                    break;
            }

            if(birthable != null) {
                birthables.add(birthable);
            }
            
            line = scanner.nextLine();
        }

        String year = scanner.nextLine();

        for (Birthable birthable : birthables) {
            if (birthable.getBirthDate().endsWith(year)) {
                System.out.println(birthable.getBirthDate());
            }
        }
    }
}
