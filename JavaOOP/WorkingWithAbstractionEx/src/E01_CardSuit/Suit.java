package E01_CardSuit;

public enum Suit {
    CLUBS,
    DIAMONDS,
    HEARTS,
    SPADES;



    public String toString () {
        return String.format("Ordinal value: %d; Name value: %s", ordinal(), name());
    }
}
