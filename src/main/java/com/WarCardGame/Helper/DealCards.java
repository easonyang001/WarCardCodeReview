package com.WarCardGame.Helper;

import com.WarCardGame.Deck.CardDeck;
import com.WarCardGame.Player.Player;

// Helper method to deal the same number of cards to different players based on the total number of players
public class DealCards {
	public static Player[] dealCards(CardDeck deck, int numberOfPlayers) {
    	Player[] players = new Player[numberOfPlayers];
        for (int i=0; i<players.length; i++) {
            players[i] = new Player();
        }
        int cardsPerPlayer = deck.numOfCards() / numberOfPlayers;

        for (int i=0; i<cardsPerPlayer*numberOfPlayers; i++) {
            players[i%numberOfPlayers].addCard(deck.deal());
        }
        
        return players;
    }

}
