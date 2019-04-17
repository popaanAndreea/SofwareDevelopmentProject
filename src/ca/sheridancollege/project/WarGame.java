package ca.sheridancollege.project;

import ca.sheridancollege.project.card.DeckOfWarCards;
import ca.sheridancollege.project.card.WarCard;
import ca.sheridancollege.project.card.WarPile;
import java.util.ArrayList;

/**
 *
 * @author fernandofedele
 */
public class WarGame extends Game {

    // data fields specific to war game
    private final int numTurns;
    private DeckOfWarCards deck;
    private WarPlayer player1;
    private WarPlayer player2;
    private int turnNum = 1;

    /* 
    we can't use the ArrayList<Player> players data field or the setPlayers
    method because of how container classes handle inheritance. It is further 
    explained here : https://stackoverflow.com/questions/44221882/passing-an-arraylist-of-subclass-to-a-constructor-that-takes-arraylist-of-superc/44221916
     */

    // gets a shuffled deck of cards and uses it to set the WarPile for each Player
    public WarGame(int numTurns, WarPlayer player1, WarPlayer player2) {
        super("War");
        this.numTurns = numTurns;
        this.player1 = player1;
        this.player2 = player2;
        deck = new DeckOfWarCards();
        setPlayerWarPiles();
    }

    // plays a single turn of war
    @Override
    public void play() {
        
        // create an arrayList containing all the character's top cards
        ArrayList<WarCard> fightingCards = new ArrayList<>();
        fightingCards.add(player1.getWarPile().takeTopCard());
        fightingCards.add(player2.getWarPile().takeTopCard());
        
        // get cards we just picked
        WarCard card1 = fightingCards.get(0);
        WarCard card2 = fightingCards.get(1);
        
        // display which cards are played
        System.out.println(player1.getPlayerID() + " plays " + card1);
        System.out.println(player2.getPlayerID() + " plays " + card2);
        System.out.println();
        
        // 1st possibility - card1 is greater than card2 - player1 wins
        if (card1.getValue() > card2.getValue()) {
            System.out.println(player1 + " wins this turn");
            // add the cards used in the battle to player1's warPile
            player1.getWarPile().addCards(fightingCards);
        } 
        
        // 2nd possibility - card1 is less than card2 - player2 wins
        else if (card1.getValue() < card2.getValue()) {
            System.out.println(player2 + " wins this turn");
            // add the cards used in the battle to player1's warPile
            player2.getWarPile().addCards(fightingCards);
        }
        
        // 3rd possibility - two cards have same value
        else {
            System.out.println("WAR DECLARED");
            
            declareWar(fightingCards);
        }
        turnNum++;
    }
    
    public void declareWar(ArrayList<WarCard> fightingCards) {
        // place 3 top cards from both players into the pile (face down)
        System.out.println(player1 + " places 3 cards face down");
        fightingCards.add(player1.getWarPile().takeTopCard());
        fightingCards.add(player1.getWarPile().takeTopCard());
        fightingCards.add(player1.getWarPile().takeTopCard());
        
        System.out.println(player2 + " places 3 cards face down");
        fightingCards.add(player2.getWarPile().takeTopCard());
        fightingCards.add(player2.getWarPile().takeTopCard());
        fightingCards.add(player2.getWarPile().takeTopCard());
        
        // use players next two cards to fight again
        fightingCards.add(player1.getWarPile().takeTopCard());
        fightingCards.add(player2.getWarPile().takeTopCard());
        // these will aways be last 2 cards in deck
        WarCard card1 = fightingCards.get(fightingCards.size() - 2);
        WarCard card2 = fightingCards.get(fightingCards.size() - 1);
        
        // display which cards are played
        System.out.println(player1.getPlayerID() + " plays " + card1);
        System.out.println(player2.getPlayerID() + " plays " + card2);
        System.out.println();
        
        // compare these cards again
        if (card1.getValue() > card2.getValue()) {
            System.out.println(player1 + " wins the epic battle!");
            // add the cards used in the battle to player1's warPile
            player1.getWarPile().addCards(fightingCards);
        } else if (card1.getValue() < card2.getValue()) {
            System.out.println(player2 + " wins the epic battle!");
            // add the cards used in the battle to player1's warPile
            player2.getWarPile().addCards(fightingCards);
        } 
        // if the two cards are once again the same, declare war again recursively
        else {
            System.out.println("WAR DECLARED AGAIN");
            declareWar(fightingCards);
        }
    }

    @Override
    public void declareWinner() {
        if (player1.getWarPile().getPileSize() > player2.getWarPile().getPileSize()) {
            System.out.println(player1 + " wins! Congratulations!");
        } else if (player1.getWarPile().getPileSize() < player2.getWarPile().getPileSize()) {
            System.out.println(player2 + " wins! Congratulations!");
        } 
        // player 1 and player 2 tie
        else {
            System.out.println(player1 + " and " + player2 + " tie.");
        }
    }
    
    // returns true if the game can and should continue
    public boolean canPlay() {
        boolean canPlay = true;
        if (numTurns <= turnNum) {
            canPlay = false;
        } else if (player1.getWarPile().getPileSize() == 0) {
            canPlay = false;
        } else if (player2.getWarPile().getPileSize() == 0) {
            canPlay = false;
        }
        return canPlay;
    }
    
    public final void setPlayerWarPiles() {
        // each player gets 26 cards from the deck
        int cardsPerPlayer = 26;
        
        player1.setWarPile(new WarPile(deck.giveOutCards(cardsPerPlayer)));
        player2.setWarPile(new WarPile(deck.giveOutCards(cardsPerPlayer)));
        
    }

    public WarPlayer getPlayer1() {
        return player1;
    }

    public WarPlayer getPlayer2() {
        return player2;
    }

    public int getTurnNum() {
        return turnNum;
    }
}
