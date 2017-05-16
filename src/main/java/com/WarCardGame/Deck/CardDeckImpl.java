package com.WarCardGame.Deck;

import java.util.ArrayList;
import java.util.Collections;

import com.WarCardGame.Card.Card;
import com.WarCardGame.Rank.CardRank;
import com.WarCardGame.Rank.CardRankImpl;
import com.WarCardGame.Suit.CardSuit;
import com.WarCardGame.Suit.CardSuitImpl;

public class CardDeckImpl implements CardDeck {
  private ArrayList<Card> cards = null;

  public void newDeck( int numberOfSuits, int numberOfRanks ) {
    this.cards = new ArrayList<Card>();

    for (int i=0; i < numberOfSuits; i++) {
      CardSuit suit = new CardSuitImpl("suit_" + i);
      for (int j=0; j < numberOfRanks; j++) {
        CardRank rank = new CardRankImpl(j);
        cards.add(new Card(rank, suit));
      }
    }
  }


  public void shuffle() {
    if (cards == null) {
      throw new RuntimeException("newDeck() must be called first");
    }
    Collections.shuffle(this.cards);
  }


  public Card deal() {
    if (this.cards == null) {
      throw new RuntimeException("create() must be called first");
    }
    if (cards.size() == 0) {
      return null;
    }
    return cards.remove(0);
  }

  public int numOfCards() {
    return cards.size();
  }
}

