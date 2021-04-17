import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class E03_LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> keyMaterials = new HashMap<>();
        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);

        Map<String, Integer> junkItems = new TreeMap<>();

        boolean isThereWinner = false;
        while (!isThereWinner) {
            String[] materials = scanner.nextLine().split("\\s+");

            for (int i = 0; i < materials.length; i += 2) {
                int currentCount = Integer.parseInt(materials[i]);
                String currentMaterial = materials[i + 1].toLowerCase();

                if (currentMaterial.equals("shards") || currentMaterial.equals("fragments")
                        || currentMaterial.equals("motes")) {

                    keyMaterials.put(currentMaterial, keyMaterials.get(currentMaterial) + currentCount);
                    if (keyMaterials.get(currentMaterial) >= 250) {
                        keyMaterials.put(currentMaterial, keyMaterials.get(currentMaterial) - 250);

                        String legendary = null;

                        if(currentMaterial.equals("shards")){
                            legendary = "Shadowmourne";
                        } else if (currentMaterial.equals("fragments")){
                            legendary = "Valanyr";
                        } else {
                            legendary = "Dragonwrath";
                        }

                        System.out.println(legendary + " obtained!");

                        isThereWinner = true;
                        break;
                    }

                } else {
                    junkItems.putIfAbsent(currentMaterial, 0);
                    int currentJunkQ = junkItems.get(currentMaterial);
                    junkItems.put(currentMaterial, currentJunkQ + currentCount);
                }
            }
        }

        keyMaterials.entrySet().stream()
                .sorted((e1, e2) -> {
                    int result = e2.getValue().compareTo(e1.getValue());
                    if (result == 0) {
                        result = e1.getKey().compareTo(e2.getKey());
                    }
                    return result;
                }).forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));

        junkItems.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
