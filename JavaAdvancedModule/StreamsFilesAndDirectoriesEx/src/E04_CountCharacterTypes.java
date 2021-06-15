import java.io.*;
import java.util.LinkedHashMap;
import java.util.Set;

public class E04_CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        String fileName = "E:\\IntelliJWorkspace\\JavaAdvancedModule\\StreamsFilesAndDirectoriesEx\\resources\\input.txt";
        FileInputStream inputStream = new FileInputStream(fileName);

        LinkedHashMap<String, Integer> typesCount = new LinkedHashMap<>();
        typesCount.put("Vowels", 0);
        typesCount.put("Consonants", 0);
        typesCount.put("Punctuation", 0);

        PrintWriter writer = new PrintWriter("char-type-output.txt");

        int nextByte = inputStream.read();
        while (nextByte != -1){

            if(nextByte == ' ' || nextByte == '\r' || nextByte == '\n'){
                nextByte = inputStream.read();
                continue;
            }

            typesCount.merge(getCharType((char) nextByte), 1, Integer::sum);
            nextByte = inputStream.read();
        }

        for (var entry : typesCount.entrySet()) {
            writer.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }

        writer.close();
    }

    private static String getCharType(char c) {
        Set<Character> separators = Set.of('!', ',', '.', '?');
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

        if(separators.contains(c)){
            return "Punctuation";
        } else if (vowels.contains(c)){
            return "Vowels";
        } else {
            return "Consonants";
        }
    }
}
