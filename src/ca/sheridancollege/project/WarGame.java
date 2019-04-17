package ca.sheridancollege.project;

import ca.sheridancollege.project.card.DeckOfWarCards;
import ca.sheridancollege.project.card.WarPile;
import java.util.ArrayList;

/**
 *
 * @author fernandofedele
 */
public class WarGame extends Game {

    // data fields specific to war game
    private int numTurns;
    private final int numPlayers;
    private DeckOfWarCards deck;
    private ArrayList<WarPlayer> warPlayers;

    /* 
    we can't use the ArrayList<Player> players data field or the setPlayers
    method because of how container classes handle inheritance. It is further 
    explained here : https://stackoverflow.com/questions/44221882/passing-an-arraylist-of-subclass-to-a-constructor-that-takes-arraylist-of-superc/44221916
     */

    // gets a shuffled deck of cards and uses it to set the WarPile for each Player
    public WarGame(int numTurns, ArrayList<WarPlayer> warPlayers) {
        super("War");
        this.numTurns = numTurns;
        this.warPlayers = warPlayers;
        numPlayers = warPlayers.size();
        deck = new DeckOfWarCards();
        
    }

    @Override
    public void play() {
        int turnsLeft = numTurns;
        while (turnsLeft > 0) {

            turnsLeft--;
        }
        declareWinner();
    }

    @Override
    public void declareWinner() {

    }
    
    public void setPlayerWarPiles() {
        // each player gets an even number of cards
        // in 3 player game each player gets 17 cards - only 51 cards used
        int cardsPerPlayer = 52 / numPlayers;
        for (WarPlayer player: warPlayers) {
            // create the WarPile from the deck
            WarPile pile = new WarPile(deck.giveOutCards(cardsPerPlayer));
        }
    }
}
