package ca.sheridancollege.project;

import ca.sheridancollege.project.Card;

/**
 *
 * @author fernandofedele
 */
public class WarCard extends Card {

    // data fields
    private String suit;
    private int value;

    public static final String[] SUITS = {"Hearts", "Diamonds", "Spades", "Clubs"};

    public WarCard(String suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        String valueName = "";
        switch (this.getValue()) {
            case (2): valueName = "Two"; break;
            case (3): valueName = "Three"; break;
            case (4): valueName = "Four"; break;
            case (5): valueName = "Five"; break;
            case (6): valueName = "Six"; break;
            case (7): valueName = "Seven"; break;
            case (8): valueName = "Eight"; break;
            case (9): valueName = "Nine"; break;
            case (10): valueName = "Ten"; break;
            case (11): valueName = "Jack"; break;
            case (12): valueName = "Queen"; break;
            case (13): valueName = "King"; break;
            case (14): valueName = "Ace"; break;

        }
        String format = "%s of %s";
        return String.format(format, valueName, getSuit());
    }

}
