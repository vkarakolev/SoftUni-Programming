import java.util.*;

public class E07_OrderByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> persons = new ArrayList<>();
        String command = scanner.nextLine();

        while(!command.equals("End")){
            String[] personData = command.split(" ");
            Person person = new Person(personData);
            persons.add(person);

            command = scanner.nextLine();
        }

        Collections.sort(persons, Comparator.comparing(Person::getAge));

        for (Person person : persons) {
            System.out.println(person.toString(person));
        }

    }

    static class Person{
        String name;
        String id;
        int age;

        public Person (String[] data){
            this.name = data[0];
            this.id = data[1];
            this.age = Integer.parseInt(data[2]);
        }

        public int getAge(){
            return age;
        }

        public String toString(Person person){
            String output = String.format("%s with ID: %s is %d years old.",
                    person.name, person.id, person.age);
            return output;
        }
    }
}
