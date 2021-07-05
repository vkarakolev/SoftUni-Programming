package E02_CardRank;

import input.Reader;
import output.ConsolePrinter;

public class Main {
    public static void main(String[] args) {
        String[] command = Reader.readStringArray("\\s+");
        if(command[1].equals("Ranks")) {
            ConsolePrinter.printLine("Card Ranks:");
            for (Rank value : Rank.values()) {
                ConsolePrinter.printLine(value.toString());
            }
        }
    }
}
