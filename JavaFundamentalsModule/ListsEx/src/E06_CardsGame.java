import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E06_CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> firstDeck = readIntegerList(scanner);
        List<Integer> secondDeck = readIntegerList(scanner);

        while (!firstDeck.isEmpty() && !secondDeck.isEmpty()){
            int firstCard = firstDeck.get(0);
            int secondCard = secondDeck.get(0);

            if (firstCard > secondCard){
                firstDeck.add(firstCard);
                firstDeck.add(secondCard);
            } else if (secondCard > firstCard) {
                secondDeck.add(secondCard);
                secondDeck.add(firstCard);
            }

            firstDeck.remove(0);
            secondDeck.remove(0);
        }

        int sum = 0;
        if (firstDeck.isEmpty()){
            for (Integer integer : secondDeck) {
                sum += integer;
            }
            System.out.printf("Second player wins! Sum: %d", sum);
        } else {
            for (Integer integer : firstDeck) {
                sum += integer;
            }
            System.out.printf("First player wins! Sum: %d", sum);
        }
    }

    static List<Integer> readIntegerList(Scanner scanner) {
        String[] inputLine = scanner.nextLine().split("\\s+");
        List<Integer> inputList = new ArrayList<>();

        for (String s : inputLine) {
            inputList.add(Integer.parseInt(s));
        }

        return (inputList);
    }
}
