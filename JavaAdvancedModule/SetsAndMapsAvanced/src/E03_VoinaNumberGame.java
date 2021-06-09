import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E03_VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<Integer> firstDeck = readLinkedHashSet(scanner.nextLine());
        LinkedHashSet<Integer> secondDeck = readLinkedHashSet(scanner.nextLine());

        int rounds = 50;

        while (rounds-- > 0){
            int firstCard = getFirst(firstDeck);
            int secondCard = getFirst(secondDeck);

            firstDeck.remove(firstCard);
            secondDeck.remove(secondCard);

            if(firstCard > secondCard){
                firstDeck.add(firstCard);
                firstDeck.add(secondCard);
            } else if (secondCard > firstCard){
                secondDeck.add(firstCard);
                secondDeck.add(secondCard);
            }

            if(firstDeck.isEmpty() || firstDeck.isEmpty()){
                break;
            }
        }

        if(firstDeck.size() > secondDeck.size()){
            System.out.println("First player win!");
        } else if (secondDeck.size() > firstDeck.size()){
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }

    private static int getFirst(LinkedHashSet<Integer> deck) {
        return deck.stream().findFirst().orElse(0);
    }

    private static LinkedHashSet<Integer> readLinkedHashSet(String line) {
        return Arrays.stream(line.split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
