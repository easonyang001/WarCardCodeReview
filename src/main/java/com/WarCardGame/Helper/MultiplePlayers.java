package com.WarCardGame.Helper;

import com.WarCardGame.Player.Player;

// To confirm there is more than one player in the game

public class MultiplePlayers {
    public static boolean multipleNonEmptyPlayers(Player[] players) {
        int numNonEmpty = 0;
        for (int i=0; i<players.length; i++) {
            if (players[i].handSize() > 0) {
                numNonEmpty ++;
            }
        }
        return numNonEmpty > 1;
    }
}
