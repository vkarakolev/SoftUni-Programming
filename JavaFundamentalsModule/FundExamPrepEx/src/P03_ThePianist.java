import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P03_ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Piece> collection = new HashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] pieceData = scanner.nextLine().split("\\|");
            String name = pieceData[0];
            String composer = pieceData[1];
            String key = pieceData[2];

            Piece p = new Piece(name, composer, key);
            collection.put(p.getName(), p);
        }

        String command = scanner.nextLine();
        while(!command.equals("Stop")){
            String[] operations = command.split("\\|");
            String pieceName = operations[1];

            switch (operations[0]){
                case "Add":
                    if(collection.get(pieceName) == null){
                        String composer = operations[2];
                        String key = operations[3];
                        Piece newPiece = new Piece(pieceName, composer, key);
                        collection.put(newPiece.getName(), newPiece);

                        System.out.printf("%s by %s in %s added to the collection!%n", pieceName, composer, key);
                    } else {
                        System.out.println(pieceName + " is already in the collection!");
                    }
                    break;
                case "Remove":
                    if(collection.containsKey(pieceName)){
                        collection.remove(pieceName);
                        System.out.println("Successfully removed " + pieceName + "!");
                    } else {
                        System.out.println("Invalid operation! " + pieceName + " does not exist in the collection.");
                    }
                    break;
                case "ChangeKey":
                    if(collection.containsKey(pieceName)){
                        String newKey = operations[2];
                        collection.get(pieceName).setKey(newKey);
                        System.out.printf("Changed the key of %s to %s!%n", pieceName, newKey);
                    } else {
                        System.out.println("Invalid operation! " + pieceName + " does not exist in the collection.");
                    }
                    break;
            }

            command = scanner.nextLine();
        }

        collection.values()
                .stream()
                .sorted((a, b) -> {
                    if(!a.getName().equals(b.getName())){
                        return (a.getName().compareTo(b.getName()));
                    } else {
                        return (a.getComposer().compareTo(b.getComposer()));
                    }
                })
                .map(e -> String.format("%s -> Composer: %s, Key: %s", e.getName(), e.getComposer(), e.getKey()))
                .forEach(System.out::println);
    }

    static class Piece{
        String name;
        String composer;
        String key;

        public Piece(String name, String composer, String key) {
            this.name = name;
            this.composer = composer;
            this.key = key;
        }

        public String getName() {
            return name;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getComposer() {
            return composer;
        }
    }
}
