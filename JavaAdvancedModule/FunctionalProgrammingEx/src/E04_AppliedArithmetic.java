import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class E04_AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = readArray(scanner.nextLine());

        Function<int[], int[]> add = arr -> Arrays.stream(arr).map(e -> e + 1).toArray();
        Function<int[],int[]> multiply = arr -> Arrays.stream(arr).map(e -> e * 2).toArray();
        Function<int[],int[]> subtract = arr -> Arrays.stream(arr).map(e -> e - 1).toArray();
        Consumer<int[]> print = arr -> Arrays.stream(arr).forEach(e -> System.out.print(e + " "));

        String command = scanner.nextLine();
        while (!command.equals("end")){
            switch (command){
                case "add":
                    numbers = add.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiply.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtract.apply(numbers);
                    break;
                case "print":
                    print.accept(numbers);
                    System.out.println();
                    break;
            }

            command = scanner.nextLine();
        }

    }

    private static int[] readArray(String line) {
        return Arrays.stream(line.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
