import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class E01_AdvertisementMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] phrases = {"Excellent product.", "Such a great product.",
                "I always use that product.", "Best product of its category.",
                "Exceptional product.", "I can’t live without this product."};
        String[] events = {"Now I feel good.", "I have succeeded with this product.",
                "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.",
                "Try it yourself, I am very satisfied.", "I feel great!"};
        String[] authors = {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
        String[] cities = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

        Random randomGenerator = new Random();

        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.printf("%s %s %s - %s%n", phrases[randomGenerator.nextInt(phrases.length)],
                    events[randomGenerator.nextInt(events.length)],
                    authors[randomGenerator.nextInt(authors.length)],
                    cities[randomGenerator.nextInt(cities.length)]);
        }
    }

}
