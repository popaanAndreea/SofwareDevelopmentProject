
package ca.sheridancollege.project;

import ca.sheridancollege.project.card.WarPile;

/**
 *
 * @author fernandofedele
 */
public class WarPlayer extends Player {

    private WarPile warPile;
    
    public WarPlayer(String name) {
        super(name);
    }
    
    public void setWarPile(WarPile warPile) {
        this.warPile = warPile;
    }
    
    @Override
    public void play() {
        
    }

}
