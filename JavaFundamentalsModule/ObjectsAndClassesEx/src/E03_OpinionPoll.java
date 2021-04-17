import javax.xml.namespace.QName;
import java.util.*;

public class E03_OpinionPoll {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());

        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            String[] personInfo = scanner.nextLine().split("\\s+");
            String personName = personInfo[0];
            int personAge = Integer.parseInt(personInfo[1]);

            Person p = new Person(personName, personAge);
            if(personAge > 30){
               
                persons.add(p);
            }
        }

        Collections.sort(persons, Comparator.comparing(Person::getName));

        for (Person person : persons) {
            System.out.print(person.toString());
        }


    }

    static class Person {
        String name;
        int age;

        public Person(String name, int age){
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String toString(){
            return String.format("%s - %d%n", getName(), getAge());
        }
    }

}
