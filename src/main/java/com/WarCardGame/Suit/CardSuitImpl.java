package com.WarCardGame.Suit;

public class CardSuitImpl implements CardSuit {

    private String suitName;

    public CardSuitImpl(String name) {
        this.suitName = name;
    }

    public String getName() {
        return suitName;
    }

    public boolean equals(Object o) {
        if (!(o instanceof CardSuit)) {
            return false;
        }
        CardSuit otherSuit = (CardSuit) o;
        return suitName.equals(otherSuit.getName());
    }

    public String toString() {
        return suitName;
    }
}
