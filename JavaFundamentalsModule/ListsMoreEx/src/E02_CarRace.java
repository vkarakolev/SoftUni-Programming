import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E02_CarRace {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.stream(new Scanner(System.in).nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int finishIndex = numbers.size() / 2;

        double leftTime = 0;
        for (int i = 0; i < finishIndex; i++) {
            if(numbers.get(i) == 0){
                leftTime *= 0.8;
                continue;
            }

            leftTime += numbers.get(i);
        }

        double rightTime = 0;
        for (int i = numbers.size() - 1; i > finishIndex; i--) {
            if(numbers.get(i) == 0){
                rightTime *= 0.8;
                continue;
            }

            rightTime += numbers.get(i);
        }

        String winner;
        double winnerTime;
        if(leftTime < rightTime){
            winner = "left";
            winnerTime = leftTime;
        } else {
            winner = "right";
            winnerTime = rightTime;
        }

        System.out.printf("The winner is %s with total time: %.1f", winner, winnerTime);
    }
}
