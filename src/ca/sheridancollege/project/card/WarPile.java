package ca.sheridancollege.project.card;

import java.util.ArrayList;

/**
 *
 * @author fernandofedele
 */
public class WarPile extends GroupOfCards {

    private ArrayList<WarCard> warPile;
    
    public WarPile(ArrayList<WarCard> warCards) {
        super(warCards.size());
        warPile = warCards;
    }
    
    public int getPileSize() {
        return warPile.size();
    }
    
    public WarCard takeTopCard() {
        // takes the card at the first position, removes it from the pile 
        // and returns it. Will shift all other WarCards one index left
        return warPile.remove(0);
    }
    
    public void addCards(ArrayList<WarCard> cardList) {
        // adds a list of cards to the bottom of the pile
        for (WarCard card: cardList) {
            warPile.add(getPileSize(), card);
        }
    }
    
    @Override 
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (WarCard warCard: warPile) {
            builder.append(warCard);
            builder.append("\n");
        }
        return builder.toString();
    }
}
