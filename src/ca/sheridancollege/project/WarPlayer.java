package ca.sheridancollege.project;

import ca.sheridancollege.project.card.WarCard;
import ca.sheridancollege.project.card.WarPile;

/**
 * A class that models a player of the card game War
 * @author fernandofedele
 */
public class WarPlayer extends Player {

    private WarPile warPile;
    
    public WarPlayer(String name) {
        super(name);
    }
    
    public WarPile getWarPile() {
        return warPile;
    }
    
    public void setWarPile(WarPile warPile) {
        this.warPile = warPile;
    }
    
    @Override 
    public String toString() {
        return getPlayerID();
    }
    
    public String displayNumCardsLeft() {
        String format = "%s has %d cards left";
        return String.format(format, getPlayerID(), warPile.getPileSize());
    }
    
    public WarCard showTopCard() {
        return warPile.showTopCard();
    }

    @Override
    public WarCard play() {
        return warPile.takeTopCard();
    }

}
