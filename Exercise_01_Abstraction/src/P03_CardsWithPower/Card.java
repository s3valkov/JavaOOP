package P03_CardsWithPower;

public class Card {
    private String card;
    private String cardSuit;

    public int getPowerCard() {
        return CardPower.valueOf(card).getPower() + CardSuit.valueOf(cardSuit).getValue();
    }


    public Card(String card, String cardSuit) {
        this.card = card;
        this.cardSuit = cardSuit;
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d"
                , card, cardSuit, getPowerCard());
    }
}
