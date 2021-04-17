import java.util.*;

public class P03_PlantDiscovery {
    public static void main(String[] args) {
        Map<String, Plant> plantsByName = new HashMap<>();

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] nameAndRarity = scanner.nextLine().split("<->");
            Plant p = new Plant(nameAndRarity[0], Integer.parseInt(nameAndRarity[1]));
            plantsByName.put(p.getName(), p);
        }

        String command = scanner.nextLine();
        while(!command.equals("Exhibition")){
            String[] manipulations = command.split("\\W+");
            String plantName = manipulations[1];
            switch (manipulations[0]){
                case "Rate":
                    double rating = Double.parseDouble(manipulations[2]);
                    Plant ratePlant = plantsByName.get(plantName);
                    if(ratePlant != null) {
                        ratePlant.addRating(rating);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "Update":
                    int newRarity = Integer.parseInt(manipulations[2]);
                    Plant updatePlant = plantsByName.get(plantName);
                    if(updatePlant != null) {
                        updatePlant.setRarity(newRarity);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "Reset":
                    Plant resetPlant = plantsByName.get(plantName);
                    if(resetPlant != null) {
                        resetPlant.resetRatings();
                    } else {
                        System.out.println("error");
                    }
                    break;
                default:
                    System.out.println("error");
                    break;
            }

            command = scanner.nextLine();
        }

        System.out.println("Plants for the exhibition:");
        plantsByName.values()
                .stream()
                .sorted((a, b) -> {
                    if(a.getRarity() != b.getRarity()){
                        return Integer.compare(b.getRarity(), a.getRarity());
                    } else {
                        return Double.compare(b.getAverageRatings(), a.getAverageRatings());
                    }
                })
                .map(p -> String.format("- %s; Rarity: %d; Rating: %.2f",p.getName(), p.getRarity(), p.getAverageRatings()))
                .forEach(System.out::println);
    }

    public  static class Plant {
        String name;
        int rarity;
        List<Double> ratings;

        public Plant (String name, int rarity) {
            this.name = name;
            this.rarity = rarity;
            this.ratings = new ArrayList<>();
        }

        public void addRating(Double rating){
            this.ratings.add(rating);
        }

        public void resetRatings(){
            this.ratings.clear();
        }

        public int getRarity() {
            return rarity;
        }

        public double getAverageRatings() {
            if(this.ratings.isEmpty()){
                return 0;
            }

            double avgRatings = 0;
            for (Double r : ratings) {
                avgRatings += r;
            }

            avgRatings /= this.ratings.size();
            return avgRatings;
        }

        public String getName() {
            return name;
        }

        public void setRarity(int rarity) {
            this.rarity = rarity;
        }
    }
}
