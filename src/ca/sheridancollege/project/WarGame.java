package ca.sheridancollege.project;

import ca.sheridancollege.project.card.DeckOfWarCards;
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

    public WarGame(int numTurns, ArrayList<WarPlayer> warPlayers) {
        super("War");
        this.numTurns = numTurns;
        this.warPlayers = warPlayers;
        numPlayers = warPlayers.size();
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
}
