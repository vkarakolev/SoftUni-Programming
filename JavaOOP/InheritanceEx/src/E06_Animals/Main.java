package E06_Animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Animal> animals = new ArrayList<>();

        String command = scanner.nextLine();
        while (!command.equals("Beast!")) {
            String type = command;
            String[] data = scanner.nextLine().split("\\s+");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            String gender = data[2];

            try {
                Animal animal = createNewAnimal(type, name, age, gender);
                animals.add(animal);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }

            command = scanner.nextLine();
        }

        animals.forEach(System.out::println);
    }

    private static Animal createNewAnimal(String type, String name, int age, String gender) {
        switch (type) {
            case "Dog" -> { return new Dog(name, age, gender); }
            case "Cat" -> { return new Cat(name, age, gender); }
            case "Frog" -> {return new Frog(name, age, gender); }
            case "Kitten" -> {return new Kitten(name, age, gender); }
            case "Tomcat" -> {return new Tomcat(name, age, gender); }
            default -> throw new IllegalArgumentException("Wrong type");
        }
    }
}
