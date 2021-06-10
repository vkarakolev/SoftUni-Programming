import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class E07_CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>> continents = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] cityData = scanner.nextLine().split("\\s+");

            String continent = cityData[0];
            String country = cityData[1];
            String city = cityData[2];

            continents.putIfAbsent(continent, new LinkedHashMap<>());
            LinkedHashMap<String, ArrayList<String>> countries = continents.get(continent);
            countries.putIfAbsent(country, new ArrayList<>());
            countries.get(country).add(city);
        }

        printOutput(continents);
    }

    private static void printOutput(LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>> continents) {
        for (var entry : continents.entrySet()) {
            String continent = entry.getKey();
            System.out.println(continent + ":");

            for (var innerEntry : entry.getValue().entrySet()) {
                StringBuilder innerOutput = new StringBuilder();
                String country = innerEntry.getKey();
                String cities = String.join(", ", innerEntry.getValue());

                innerOutput.append(" ").append(country).append(" -> ").append(cities);
                System.out.println(innerOutput);
            }
        }
    }
}
