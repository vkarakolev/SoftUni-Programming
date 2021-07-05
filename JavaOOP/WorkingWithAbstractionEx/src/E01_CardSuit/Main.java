package E01_CardSuit;

import input.Reader;
import output.ConsolePrinter;

public class Main {
    public static void main(String[] args) {
        String[] command = Reader.readStringArray("\\s+");
        if(command[1].equals("Suits")) {
            ConsolePrinter.printLine("Card Suits:");
            for (Suit value : Suit.values()) {
                ConsolePrinter.printLine(value.toString());
            }
        }
    }
}
