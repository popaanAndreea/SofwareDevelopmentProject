

package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *
 * @author andre
 */
public class WarGame extends Game {
    
    private int turns = 30;
    private int deckSize;
    ArrayList<WarCard> deck = new ArrayList<>();
    WarCard card = new WarCard();

    public WarGame(String givenName) {
        super(givenName);
    }

    @Override
    public void play() {
        for(int i = 0; i < turns; i++){
            if(i < 30){
                flipCard();
            }else{
                declareWinner();
            }
        }
        declareWinner();
    }

    @Override
    public void declareWinner() {
        if(deckSize == 52){
            System.out.println("Winner");
        }
    }
    
    public WarCard flipCard(){
        return deck.remove(0);
    }
    
    public WarCard addCard(){
        return deck.add(card);
    }
}
