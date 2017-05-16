package com.WarCardGame.Card;

import com.WarCardGame.Rank.CardRank;
import com.WarCardGame.Suit.CardSuit;

public class Card {
    private CardRank rank;
    private CardSuit suit;

    public Card(CardRank rank, CardSuit suit) {
        this.rank = rank;
        this.suit = suit;
    }
    
    // if the rank and suit are equal, then the card are equal
    public boolean equals(Object other) {
        if (!(other instanceof Card)) {
            return false;
        }
        Card otherCard = (Card) other;
        return this.rank.equals(otherCard.rank) && this.suit.equals(otherCard.suit);
    }

    public String toString() {
        return "Card<" + rank.toString() + " of " + suit.toString() + ">";
    }
    
    // compare the value between two cards
    public int compareTo(Card otherCard) {
        return this.rank.compareTo(otherCard.rank);
    }
}