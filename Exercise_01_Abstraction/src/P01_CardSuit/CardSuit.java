package P01_CardSuit;

public enum CardSuit {
    CLUBS(0),
    DIAMONDS(1),
    HEARTS(2),
    SPADES(3);

    int value;

    CardSuit(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("Original value: %d; Name value: %s"
                , this.getValue(), this.name());
    }
}
