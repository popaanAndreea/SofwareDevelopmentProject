
package ca.sheridancollege.project.game;

/**
 *
 * @author fernandofedele
 */
public class WarGame extends Game {
    
    // data fields specific to war game
    private int numTurns;
    private final int numPlayers;
    
    public WarGame(int numTurns, int numPlayers) {
        super("War");
        this.numTurns = numTurns;
        this.numPlayers = numPlayers;
    }

    @Override
    public void play() {
        
    }

    @Override
    public void declareWinner() {
        
    }
}
