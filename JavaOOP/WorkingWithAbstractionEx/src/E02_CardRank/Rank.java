package E02_CardRank;

public enum Rank {
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING,
    ACE;

    public String toString () {
        return String.format("Ordinal value: %d; Name value: %s", ordinal(), name());
    }
}
