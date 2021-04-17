import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E09_PokemonDontGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> distances = readListOfIntegers(scanner);

        int sum = 0;
        while (!distances.isEmpty()){
            int index = Integer.parseInt(scanner.nextLine());
            int removedElement = 0;

            if(index < 0){
                removedElement = distances.get(0);
                distances.set(0, distances.get(distances.size() - 1));
            } else if (index > distances.size() - 1){
                removedElement = distances.get(distances.size() - 1);
                distances.set(distances.size() - 1, distances.get(0));
            } else {
                removedElement = distances.get(index);
                distances.remove(index);
            }

            sum += removedElement;

            for (int i = 0; i < distances.size(); i++) {
                int currentElement = distances.get(i);

                if(currentElement > removedElement){
                    distances.set(i, currentElement - removedElement);
                } else {
                    distances.set(i, currentElement + removedElement);
                }
            }

        }

        System.out.println(sum);
    }

    static List<Integer> readListOfIntegers (Scanner scanner){
        String[] input = scanner.nextLine().split("\\s+");
        List<Integer> inputList = new ArrayList<>();

        for (String s : input) {
            inputList.add(Integer.parseInt(s));
        }

        return (inputList);
    }
}
