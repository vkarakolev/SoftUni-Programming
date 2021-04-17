import java.util.Scanner;

public class E09_KaminoFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dnaLength = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();

        while(!command.equals("Clone them!")){
            command = scanner.nextLine();
            String[] dna = command.split("!");
            int[] sequenceIndexes = new int[dna.length];
            int counter = 1;
            int bestSequenceIndex = Integer.MAX_VALUE;

            for (int i = 1; i < dna.length; i++) {
                if(dna[i - 1].equals(1) && dna[i].equals(1)){
                    counter++;
                    if(bestSequenceIndex > sequenceIndexes[0]){

                    }
                }
            }
        }
    }
}
