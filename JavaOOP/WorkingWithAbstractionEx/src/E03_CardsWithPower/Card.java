package E03_CardsWithPower;

import E01_CardSuit.Suit;
import E02_CardRank.Rank;

public class Card {
    private Rank rank;
    private Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getPower() {
        return rank.ordinal() + 2 + suit.ordinal() * 13;
    }

    @Override
    public String toString () {
        return String.format("Card name: %s of %s; Card power: %d", rank.name(),suit.name(), getPower());
    }
}
