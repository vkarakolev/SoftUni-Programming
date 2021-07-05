package E03_CardsWithPower;

import E01_CardSuit.Suit;
import E02_CardRank.Rank;
import input.Reader;
import output.ConsolePrinter;

public class Main {
    public static void main(String[] args) {
        String rank = Reader.readStringArray("\\s+")[0];
        String suit = Reader.readStringArray("\\s+")[0];

        Card card = new Card(Rank.valueOf(rank), Suit.valueOf(suit));
        ConsolePrinter.printLine(card.toString());
    }
}
