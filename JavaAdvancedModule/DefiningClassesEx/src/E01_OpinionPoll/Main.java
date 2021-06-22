package E01_OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Person> persons = new ArrayList<>();

        while (n-- > 0) {
            String[] personData = scanner.nextLine().split("\\s+");
            String name = personData[0];
            int age = Integer.parseInt(personData[1]);

            if(age > 30){
                Person person = new Person(name, age);
                persons.add(person);
            }
        }

        persons.stream()
                .sorted(Comparator.comparing(Person::getName))
                .map(e -> String.format("%s - %d", e.getName(), e.getAge()))
                .forEach(System.out::println);
    }
}
