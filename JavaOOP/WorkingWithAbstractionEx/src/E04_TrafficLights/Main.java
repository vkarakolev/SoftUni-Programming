package E04_TrafficLights;

import input.Reader;
import output.ConsolePrinter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String[] input = Reader.readStringArray("\\s+");
        ArrayDeque<Light> lights = fillQueue(input);
        int n = Reader.readIntArray("\\s+")[0];

        for (int i = 0; i < n; i++) {
            lights = changeMultipleLights(lights);
            ConsolePrinter.printLine(createRow(lights));
        }
    }

    private static String createRow(ArrayDeque<Light> queue) {
        StringBuilder row = new StringBuilder();
        queue.stream()
                .map(Enum::name)
                .forEach(l -> row.append(l).append(" "));

        return String.valueOf(row);
    }

    private static ArrayDeque<Light> fillQueue(String[] input) {
        return Arrays.stream(input)
                .map(Light::valueOf)
                .collect(Collectors.toCollection(ArrayDeque::new));
    }

    private static ArrayDeque<Light> changeMultipleLights(ArrayDeque<Light> queue) {
        for (int i = 0; i < queue.size(); i++) {
            queue.offer(Light.changeLight(queue.poll()));
        }
        return queue;
    }
}
