import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E05_DrumSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double savings = Double.parseDouble(scanner.nextLine());
        List<Integer> initialQuality = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> currentDrumSet = new ArrayList<>(initialQuality);

        String command = scanner.nextLine();
        while(!command.equals("Hit it again, Gabsy!")){
            int hitPower = Integer.parseInt(command);
            for (int i = 0; i < currentDrumSet.size(); i++) {
                currentDrumSet.set(i, currentDrumSet.get(i) - hitPower);

                if(currentDrumSet.get(i) <= 0){
                    int currentPrice = initialQuality.get(i) * 3;
                    if(currentPrice > savings){
                        currentDrumSet.remove(i);
                        initialQuality.remove(i);
                        i--;
                    } else {
                        savings -= currentPrice;
                        currentDrumSet.set(i, initialQuality.get(i));
                    }
                }
            }

            command = scanner.nextLine();
        }

        for (Integer i : currentDrumSet) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.printf("Gabsy has %.2flv.", savings);
    }
}
