import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P03_Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, City> targets = new HashMap<>();

        String command = scanner.nextLine();
        while (!command.equals("Sail")) {
            String[] cityData = command.split("\\|\\|");
            String cityName = cityData[0];
            int population = Integer.parseInt(cityData[1]);
            int gold = Integer.parseInt(cityData[2]);

            City c = new City(cityName, population, gold);
            if (targets.get(c.getName()) == null) {
                targets.put(c.getName(), c);
            } else {
                targets.get(cityName).setPopulation(targets.get(cityName).getPopulation() + population);
                targets.get(cityName).setGold(targets.get(cityName).getGold() + gold);
            }

            command = scanner.nextLine();
        }

        command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] events = command.split("=>");
            String townName = events[1];

            switch (events[0]) {
                case "Plunder":
                    int kills = Integer.parseInt(events[2]);
                    int stolenGold = Integer.parseInt(events[3]);

                    targets.get(townName).setPopulation(targets.get(townName).getPopulation() - kills);
                    targets.get(townName).setGold(targets.get(townName).getGold() - stolenGold);

                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", townName, stolenGold, kills);

                    if (targets.get(townName).getPopulation() == 0 || targets.get(townName).getGold() == 0) {
                        targets.remove(townName);
                        System.out.println(townName + " has been wiped off the map!");
                    }
                    break;
                case "Prosper":
                    int goldAmount = Integer.parseInt(events[2]);
                    if (goldAmount >= 0) {
                        targets.get(townName).setGold(targets.get(townName).getGold() + goldAmount);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n",
                                goldAmount, townName, targets.get(townName).getGold());
                    } else {
                        System.out.println("Gold added cannot be a negative number!");
                    }
                    break;
            }

            command = scanner.nextLine();
        }

        if (targets.isEmpty()) {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        } else {
            System.out.println("Ahoy, Captain! There are " + targets.size() + " wealthy settlements to go to:");
            targets.values()
                    .stream()
                    .sorted((a, b) -> {
                        if (a.getGold() != b.getGold()) {
                            return (Integer.compare(b.getGold(), a.getGold()));
                        } else {
                            return (a.getName().compareTo(b.getName()));
                        }
                    })
                    .map(e -> String.format("%s -> Population: %d citizens, Gold: %d kg",
                            e.getName(), e.getPopulation(), e.getGold()))
                    .forEach(System.out::println);
        }
    }

    static class City {
        String name;
        int population;
        int gold;

        public City(String name, int population, int gold) {
            this.name = name;
            this.population = population;
            this.gold = gold;
        }

        public String getName() {
            return name;
        }

        public int getPopulation() {
            return population;
        }

        public void setPopulation(int population) {
            this.population = population;
        }

        public int getGold() {
            return gold;
        }

        public void setGold(int gold) {
            this.gold = gold;
        }
    }
}
