package com.WarCardGame.Game;

import java.util.Set;
import java.util.HashSet;


import com.WarCardGame.Card.Card;
import com.WarCardGame.Deck.CardDeck;
import com.WarCardGame.Deck.CardDeckImpl;
import com.WarCardGame.Exception.DrawException;
import com.WarCardGame.Player.Player;
import com.WarCardGame.Helper.DealCards;
import com.WarCardGame.Helper.GenerateRound;
import com.WarCardGame.Helper.MultiplePlayers;

public class Game {
	
	
    private boolean printResult = false;
    public Game() {
    }

    public Game(boolean printResult) {
        this.printResult = printResult;
    }

    public void playGame(int numberOfSuits, int numberOfRanks, int numberOfPlayers) {
        CardDeck cardDeck = new CardDeckImpl();
        cardDeck.newDeck(numberOfSuits, numberOfRanks);
        cardDeck.shuffle();
        
        Player[] players = DealCards.dealCards(cardDeck, numberOfPlayers);

        int roundNumber = 0;
        
        while (MultiplePlayers.multipleNonEmptyPlayers(players)) {
            System.out.println(GenerateRound.generateRoundString(roundNumber++, players));
            OneRoundPlay(players);
        }
        System.out.println(GenerateRound.generateRoundString(roundNumber++, players));
    }
    
    // simulate the whole round with different players
    public void OneRoundPlay(Player[] players) {

        Set<Integer> winner = new HashSet<Integer>();

        Set<Card> thePot = new HashSet<Card>();

        while (true) {
            Card[] currentSubRound = new Card[players.length];
            for (int i=0; i<players.length; i++) {
                if (players[i].hasCards()) {
                    currentSubRound[i] = players[i].takeCard();
                } else {
                    currentSubRound[i] = null;
                }
            }

            winner.clear();
            Card winnerCard = null;

            for (int i=0; i<currentSubRound.length; i++) {
                if (currentSubRound[i] == null) {
                    continue;
                }

                if (winnerCard == null) {
                	winnerCard = currentSubRound[i];
                    winner.add(i);
                    continue;
                }

                int compareResult = currentSubRound[i].compareTo(winnerCard);
                if (compareResult > 0) {
                	winnerCard = currentSubRound[i];
                    winner.clear();
                    winner.add(i);
                } else if (compareResult == 0) {
                	winner.add(i);
                }
            }

            if (printResult) {
                String cRound = "* current sub-round: (Player1 play " + currentSubRound[0];
                for (int i=1; i<currentSubRound.length; i++) {
                    if (currentSubRound[i] != null) {
                        cRound += " ; " + "Player" + (i + 1) + " play " + currentSubRound[i];
                    }
                    cRound += ")";
                }
                System.out.println(cRound);
            }
            for (int i=0; i<currentSubRound.length; i++) {
                if (currentSubRound[i] != null) {
                    thePot.add(currentSubRound[i]);
                }
            }

            if (winner.size() > 1) {
                if (printResult) {
                    System.out.println("* face down sub-round");
                }
                for (int i=0; i<players.length; i++) {
                    
                    if (players[i].hasCards()) {
                        thePot.add(players[i].takeCard());
                    }
                }
            } else {
                break;
            }
        }

        if (winner.size() == 0) {

            throw new DrawException("Stop the game");
        }

        players[winner.iterator().next()].addCards(thePot);
    }

    public static void main(String[] args) {
        int numberOfSuits;
        int numberOfRanks;
        int numberOfPlayers;

        if (args.length == 3) {
            numberOfSuits = Integer.parseInt(args[0]);
            numberOfRanks = Integer.parseInt(args[1]);
            numberOfPlayers = Integer.parseInt(args[2]);
        } else {
            numberOfSuits = 4;
            numberOfRanks = 13;
            numberOfPlayers = 3;
        }
        System.out.println("Playing with " + numberOfSuits + " suits, " + numberOfRanks + " ranks, and " + numberOfPlayers + " players.");

        Game game = new Game(true);
        game.playGame(numberOfSuits, numberOfRanks, numberOfPlayers);
    }
}
