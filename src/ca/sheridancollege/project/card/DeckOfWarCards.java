
package ca.sheridancollege.project.card;

import static ca.sheridancollege.project.card.WarCard.SUITS;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author fernandofedele
 */
public class DeckOfWarCards extends GroupOfCards {
    
    private ArrayList<WarCard> deck;
    
    public DeckOfWarCards() {
        super(52);
        deck = new ArrayList<>();
        createDeck();
        System.out.println(deck.toString());
    }

    public final void createDeck() {
        for (String suit : SUITS) {
            for (int j = 2; j <= 14; j++) {
                deck.add(new WarCard(suit, j));
            }
        }
    }
    
    public ArrayList<WarCard> getDeck() {
        return deck;
    }
}
