package com.WarCardGame.Player;

import java.util.LinkedList;
import java.util.Set;

import com.WarCardGame.Card.Card;


public class Player {
	
	// List for the cards
    private LinkedList<Card> onHand = new LinkedList<Card>();
    
    // Add card to the players
    public void addCard(Card card) {
    	onHand.add(card);
    }

    // Add more than one card to the players
    public void addCards(Set<Card> cards) {
    	onHand.addAll(cards);
    }

    // Help the player to take a card
    public Card takeCard() {
        return onHand.removeFirst();
    }
    
    // Total number of the cards that player has
    public int handSize() {
        return onHand.size();
    }

    // Determine the player has at least one card
    public boolean hasCards() {
        return onHand.size() > 0;
    }


    public String toString() {
        String rv = onHand.get(0).toString();
        for (int i=1; i<onHand.size(); i++) {
            rv += "," + onHand.get(i).toString();
        }
        return rv;
    }
}
