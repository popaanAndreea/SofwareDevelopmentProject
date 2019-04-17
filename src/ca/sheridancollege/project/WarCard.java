package ca.sheridancollege.project;

/**
 *
 * @author andre
 */
public class WarCard extends Card {

    private String[] value;
    private String[] suit;

    @Override
    public String toString() {
        return value + " of " + suit;
    }
}
