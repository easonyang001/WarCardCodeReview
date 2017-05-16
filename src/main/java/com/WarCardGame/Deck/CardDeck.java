package com.WarCardGame.Deck;

import com.WarCardGame.Card.Card;

public interface CardDeck {
	  // Create a deck for the game
	  public void newDeck(int numberOfSuits, int numberOfRanks);

	  // Shuffle method for the deck
	  public void shuffle();

	  // Deal method for the deck
	  public Card deal();

	  // Get the number of the cards
	  public int numOfCards();
	}
