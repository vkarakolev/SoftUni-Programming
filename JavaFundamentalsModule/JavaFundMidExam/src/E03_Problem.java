import java.util.*;

public class E03_Problem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> words = parseLineInListElements(scanner);

        String input = scanner.nextLine();
        while (!input.equals("Stop")){
            String[] commandLine = input.split(" ");
            String command = commandLine[0];

            switch (command){
                case "Delete":
                        deleteWordAfterIndex(commandLine, words);
                    break;
                case "Swap":
                        wordsSwap(commandLine, words);
                    break;
                case "Put":
                        putWordOnPreviousIndex(commandLine, words);
                    break;
                case "Sort":
                        sortWordsDesc(words);
                    break;
                case "Replace":
                        replaceWordIfExists(commandLine, words);
                    break;
            }

            input = scanner.nextLine();
        }

        String output = String.join(" ", words);
        System.out.println(output);
    }

    static List<String> replaceWordIfExists (String[] commands, List<String> list){
        String replacingWord = commands[1];
        String replacedWord = commands[2];

        if(list.contains(replacedWord)){
            int replacedWordIndex = list.indexOf(replacedWord);
            list.remove(replacedWordIndex);
            list.add(replacedWordIndex, replacingWord);
        }

        return list;
    }

    static List<String> deleteWordAfterIndex (String[] commands, List<String> list){
        int index =Integer.parseInt(commands[1]);
        if(-2 < index && index < list.size() - 1){
            list.remove(index + 1);
        }

        return list;
    }

    static List<String> sortWordsDesc (List<String> list){
        Collections.sort(list, Collections.reverseOrder());
        return list;
    }

    static List<String> putWordOnPreviousIndex (String[] commands, List<String> list){
        String word = commands[1];
        int index = Integer.parseInt(commands[2]);

        if(0 < index && index < list.size()){
            if(index == list.size() - 1){
                list.add(word);
            } else {
                list.add(index - 1, word);
            }
        }
        return list;
    }

    static List<String> wordsSwap (String[] commands, List<String> list){
        String word1 = commands[1];
        String word2 = commands[2];

        if(list.contains(word1) && list.contains(word2)){
            int word1Index = list.indexOf(word1);
            int word2Index = list.indexOf(word2);

            list.remove(word2);
            list.add(word1Index, word2);

            list.remove(word1);
            list.add(word2Index, word1);
        }
        return list;
    }

    static List<String> parseLineInListElements (Scanner scanner){
        String[] inputLine = scanner.nextLine().split(" ");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < inputLine.length; i++) {
            list.add(inputLine[i]);
        }
        return list;
    }
}
