
package E06_GreedyTimes;

import input.Reader;
import output.ConsolePrinter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {

        long maxCapacity = Long.parseLong(Reader.readStringArray("\\s+")[0]);
        String[] safe = Reader.readStringArray("\\s+");

        Map<String, HashMap<String, Long>> bag = new HashMap<>();
        long gold = 0;
        long gem = 0;
        long cash = 0;

        for (int i = 0; i < safe.length; i += 2) {
            String name = safe[i];
            long count = Long.parseLong(safe[i + 1]);

            String item = getItemType(name);
            long totalSum = getTotalSum(bag);

            if (item == null || maxCapacity < totalSum + count) {
                continue;
            }

            switch (item) {
                case "Gem":
                    if (!bag.containsKey(item)) {
                        if (bag.containsKey("Gold")) {
                            if (count > getSum().apply(getInner(bag, "Gold"))) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (getSum().apply(getInner(bag, item)) + count > getSum().apply(getInner(bag, "Gold"))) {
                        continue;
                    }
                    break;
                case "Cash":
                    if (!bag.containsKey(item)) {
                        if (bag.containsKey("Gem")) {
                            if (count > getSum().apply(getInner(bag, "Gold"))) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (getSum().apply(getInner(bag, item)) + count > getSum().apply(getInner(bag, "Gem"))) {
                        continue;
                    }
                    break;
            }

            bag.putIfAbsent(item, new HashMap<>());
            getInner(bag, item).putIfAbsent(name, 0L);
            getInner(bag, item).merge(name, count, Long::sum);


        }

        printOutput(bag);
    }

    private static void printOutput(Map<String, HashMap<String, Long>> bag) {
        for (var entry : bag.entrySet()) {
            Long sumValues = getSum().apply(entry.getValue());

            ConsolePrinter.printLine(String.format("<%s> $%s%n", entry.getKey(), sumValues));

            entry.getValue().entrySet().stream()
                    .sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey()))
                    .map(e -> String.format("##%s - %o", e.getKey(), e.getValue()))
                    .forEach(ConsolePrinter::printLine);
        }
    }

    private static String getItemType(String name) {
        if (name.length() == 3) {
            return "Cash";
        } else if (name.toLowerCase().endsWith("gem")) {
            return "Gem";
        } else if (name.equals("gold")) {
            return "Gold";
        } else {
            return null;
        }
    }

    private static Function<HashMap<String, Long>, Long> getSum() {
        return map -> map.values()
                .stream()
                .mapToLong(l -> l)
                .sum();
    }

    private static long getTotalSum(Map<String, HashMap<String, Long>> map) {
        long sum = 0;

        for (var entry : map.entrySet()) {
            sum += getSum().apply(entry.getValue());
        }

        return sum;
    }

    private static HashMap<String, Long> getInner(Map<String, HashMap<String, Long>> map, String item) {
        return map.get(item);
    }
}