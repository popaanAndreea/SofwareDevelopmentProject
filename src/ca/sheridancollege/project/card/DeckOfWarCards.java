
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
    
    // creates a shuffled deck of 52 cards
    public DeckOfWarCards() {
        super(52);
        deck = new ArrayList<>();
        createDeck();
        shuffle();
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
    
    @Override
    public final void shuffle() {
        Collections.shuffle(deck);
    }
    
    public ArrayList<WarCard> giveOutCards(int numCards) {
        // return numCards amount of cards from the top of the deck, then 
        // remove these cards form the deck
        ArrayList<WarCard> subList = new ArrayList<>();
        while (numCards > 0) {
            subList.add(deck.remove(numCards));
            numCards--;
        }
        return subList;
    }
    
//    public static void main(String[] args) {
//        System.out.println("testing...");
//        DeckOfWarCards deckOfCards = new DeckOfWarCards();
//        for (WarCard card: deckOfCards.getDeck()) {
//            System.out.println(card);
//        }
//        System.out.println(deckOfCards.getDeck().size());
//        ArrayList<WarCard> subList = deckOfCards.giveOutCards(13);
//        System.out.println(subList.size());
//        System.out.println(deckOfCards.getDeck().size());
//    }
}
