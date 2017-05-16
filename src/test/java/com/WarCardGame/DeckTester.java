package com.WarCardGame;

import static org.junit.Assert.*;

import org.junit.Test;

import com.WarCardGame.Card.Card;
import com.WarCardGame.Deck.CardDeck;
import com.WarCardGame.Deck.CardDeckImpl;

public class DeckTester {
	
	 // Test the situation before creating
	 @Test
	  public void testBeforeCreating() {
	    CardDeck deck = new CardDeckImpl();
	    try {
	      deck.deal();
	      assertTrue("There should be a exception", false);
	    } catch (Exception e) {
	    }
	  }
	 
	 // Test the deck with small number
	  @Test
	  public void createSmallDeck() {
		CardDeck deck = new CardDeckImpl();
	    deck.newDeck(1, 1);
	  }
	  
	  // Test the deck with small number and two different suits
	  @Test
	  public void createSmallDeckAndDealTwoDifferentSuits() {
		CardDeck deck = new CardDeckImpl();
	    deck.newDeck(4,1);
	    deck.shuffle();
	    Card cardOne = deck.deal();
	    Card cardTwo = deck.deal();
	    assertNotNull(cardOne);
	    assertNotNull(cardTwo);
	    assertNotEquals("cardOne and cardTwo are not the same", cardOne, cardTwo);
	  }
	  
	  // Test the deck with small number and two different ranks
	  @Test
	  public void createSmallDeckAndDealTwoDifferentRanks() {
		CardDeck deck = new CardDeckImpl();
	    deck.newDeck(1, 5);
	    Card cardOne = deck.deal();
	    Card cardTwo = deck.deal();
	    deck.shuffle();
	    assertNotNull(cardOne);
	    assertNotNull(cardTwo);
	    assertNotEquals(cardOne, cardTwo);
	  }

	  public static void main(String[] args) {
	    org.junit.runner.JUnitCore.main("DeckTester");
	  }

}
