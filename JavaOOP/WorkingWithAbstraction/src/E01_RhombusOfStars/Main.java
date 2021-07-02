package E01_RhombusOfStars;

import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        System.out.print(createRhombusOfStars(n));
    }

    private static String createRhombusOfStars(int size) {
        StringBuilder builder = new StringBuilder();

        builder.append(printMultipleRows(1, size, +1, size))
                .append(printMultipleRows(size - 1, 1, -1, size));

        return String.valueOf(builder);
    }

    private static String printMultipleRows(int start, int end, int step, int size) {
        StringBuilder builder = new StringBuilder();

        Predicate<Integer> loopCondition = iter -> {
            if (step > 0) {
                return iter <= end;
            } else {
                return iter >= end;
            }
        };

        for (int r = start; loopCondition.test(r); r += step) {
            builder.append(createRow(r, size - r));
        }

        return String.valueOf(builder);
    }

    private static String createRow(int row, int spaces) {
        StringBuilder builder = new StringBuilder();

        builder.append(" ".repeat(spaces));
        builder.append("* ".repeat(row));
        builder.append(System.lineSeparator());

        return String.valueOf(builder);
    }
}
