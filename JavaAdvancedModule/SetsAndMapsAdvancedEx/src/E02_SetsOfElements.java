import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class E02_SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] lengths = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(lengths[0]);
        int m = Integer.parseInt(lengths[1]);

        LinkedHashSet<Integer> first = createAndFillSet(n, scanner);
        LinkedHashSet<Integer> second = createAndFillSet(m, scanner);

        ArrayList<String> repeatingElements = new ArrayList<>();

        for (Integer i : first) {
            if(second.contains(i)){
                repeatingElements.add(String.valueOf(i));
            }
        }

        System.out.println(String.join(" ", repeatingElements));
    }

    private static LinkedHashSet<Integer> createAndFillSet(int length, Scanner scanner) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();

        while (length-- > 0){
            set.add(Integer.parseInt(scanner.nextLine()));
        }

        return set;
    }
}
