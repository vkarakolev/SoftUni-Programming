import java.util.*;

public class E08_HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, HashSet<String>> hands = new LinkedHashMap<>();

        String command = scanner.nextLine();
        while (!command.equals("JOKER")){
            String[] currentDraw = command.split(": ");
            String name = currentDraw[0];
            HashSet<String> cards = hands.get(name);

            if(cards == null){
                cards = new HashSet<>();
            }

            cards.addAll(Arrays.asList(currentDraw[1].split(", ")));
            hands.put(name, cards);

            command = scanner.nextLine();
        }

        LinkedHashMap<String, Integer> points = new LinkedHashMap<>();
        for (var entry : hands.entrySet()) {
            points.put(entry.getKey(), getPoints(entry.getValue()));
        }

        points.entrySet().stream()
                .map(e -> String.format("%s: %d", e.getKey(), e.getValue()))
                .forEach(System.out::println);
    }

    private static Integer getPoints(HashSet<String> set) {
        int sum = 0;
        int power;
        int type;

        for (String s : set) {
            if(s.length() == 2) {
                power = getPower(String.valueOf(s.charAt(0)));
                type = getType(s.charAt(1));
            } else {
                power = getPower(s.substring(0, 2));
                type = getType(s.charAt(2));
            }

            sum += power * type;
        }

        return sum;
    }

    private static int getType(char c) {
        int type = 0;

        switch (c){
            case 'S':
                type = 4;
                break;
            case 'H':
                type = 3;
                break;
            case 'D':
                type = 2;
                break;
            case 'C':
                type = 1;
                break;
        }

        return type;
    }

    private static int getPower(String c) {
        int power;

        switch (c){
            case "J":
                power = 11;
                break;
            case "Q":
                power = 12;
                break;
            case "K":
                power = 13;
                break;
            case "A":
                power = 14;
                break;
            default:
                power = Integer.parseInt(c);
                break;
        }

        return power;
    }
}
