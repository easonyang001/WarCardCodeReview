package com.WarCardGame.Rank;

public class CardRankImpl implements CardRank {
    private int rankValue;

    public CardRankImpl(int rank) {
        this.rankValue = rank;
    }


    public int getValue() {
        return rankValue;
    }

    // Test the equal
    public boolean equals(Object other) {
        if (!(other instanceof CardRank)) {
            return false;
        }
        CardRank otherRank = (CardRank) other;
        return rankValue == otherRank.getValue();
    }


    public String toString() {
        return "" + rankValue;
    }

    // compare the value of the card in case the war happen
    public int compareTo(CardRank other) {
        if (rankValue == other.getValue()) {
            return 0;
        }
        if (rankValue < other.getValue()) {
            return -1;
        }
        return 1;
    }
}
