package com.WarCardGame.Helper;

import com.WarCardGame.Player.Player;

public class GenerateRound {
	 public static String generateRoundString(int roundNumber, Player[] players) {
	        String roundString = "round " + roundNumber + ": player 1 (" + players[0].handSize() + " cards)";
	        for (int i=1; i<players.length; i++) {
	            roundString += ", player" + (i+1) + " (" + players[i].handSize() + " cards)";
	        }
	        return roundString;
	    }
}
