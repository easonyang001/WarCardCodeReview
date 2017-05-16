package com.WarCardGame;

import static org.junit.Assert.*;

import org.junit.Test;

import com.WarCardGame.Card.Card;
import com.WarCardGame.Deck.CardDeck;
import com.WarCardGame.Deck.CardDeckImpl;
import com.WarCardGame.Game.Game;
import com.WarCardGame.Player.Player;
import com.WarCardGame.Rank.CardRankImpl;
import com.WarCardGame.Suit.CardSuitImpl;
import com.WarCardGame.Helper.DealCards;

public class GameTester {
	
	// Test the helper method DealCards
	@Test
	public void testDdealCards() {
		CardDeck deck = new CardDeckImpl();
		deck.newDeck(4, 13);
		Player[] players = DealCards.dealCards(deck, 3);
		assertEquals(players.length, 3);
		assertNotNull(players[0]);
		assertEquals(players[0].handSize(), 17);
		assertNotNull(players[1]);
		assertEquals(players[1].handSize(), 17);
		assertNotNull(players[2]);
		assertEquals(players[2].handSize(), 17);
	}
	
	// Test the helper method GnerateRound
	@Test
	public void testOneRound() {
		Player first = new Player();
		first.addCard(new Card(new CardRankImpl(3), new CardSuitImpl("spades")));
		Player second = new Player();
		second.addCard(new Card(new CardRankImpl(7), new CardSuitImpl("hearts")));
		assertEquals(1, first.handSize());
		assertEquals(1, second.handSize());

		Game game = new Game();
		game.OneRoundPlay(new Player[] { first, second });
		assertEquals(0, first.handSize());
		assertEquals(2, second.handSize());
	}
	
	// Test the helper method GenerateRound with empty player
	@Test
	public void testOneRoundWithAnEmptyPlayer() {
		Player first = new Player();
		Player second = new Player();
		second.addCard(new Card(new CardRankImpl(3), new CardSuitImpl("spades")));
		Player third = new Player();
		third.addCard(new Card(new CardRankImpl(7), new CardSuitImpl("hearts")));
		assertEquals(0, first.handSize());
		assertEquals(1, second.handSize());
		assertEquals(1, third.handSize());

		Game game = new Game();
		game.OneRoundPlay(new Player[] { first, second, third });
		assertEquals(0, first.handSize());
		assertEquals(0, second.handSize());
		assertEquals(2, third.handSize());
	}

	public static void main(String[] args) {
		org.junit.runner.JUnitCore.main("GameTester");
	}

}
