package ca.sheridancollege.project;

import ca.sheridancollege.project.card.WarCard;
import static ca.sheridancollege.project.card.WarCard.SUITS;
import ca.sheridancollege.project.card.WarPile;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author fernandofedele
 */
public class WarGameTest {
    
    public WarGameTest() {
    }
    
    /**
     * Test of play method, of class WarGame.
     */
    // player 1's card has higher value, they win
    @Test
    public void testPlayPlayerOneWins() {
        System.out.println("playPlayerOneWins");
        ArrayList<WarCard> player1cards = new ArrayList<>();
        player1cards.add(new WarCard(SUITS[0], 4)); // card that matters
        player1cards.add(new WarCard(SUITS[0], 6));
        
        ArrayList<WarCard> player2cards = new ArrayList<>();
        player2cards.add(new WarCard(SUITS[0], 3)); // card that matters
        player2cards.add(new WarCard(SUITS[0], 2));
        
        WarPlayer player1 = new WarPlayer("player 1");
        WarPlayer player2 = new WarPlayer("player 2");
        // warGame automatically adds random cards to each player so
        // we're going to set the WarPile after we make the game
        WarGame warGame = new WarGame(20, player1, player2);
        player1.setWarPile(new WarPile(player1cards));
        player2.setWarPile(new WarPile(player2cards));
        
        warGame.play();
        // we'll know if the correct player won by looking at the sizes of the 
        // WarPile of player1 after a turn has been played. If he has gained a 
        // card, then he has won the turn
        int expResult = 3;
        int result = player1.getWarPile().getPileSize();
        assertEquals(result, expResult);
    }
    
    // player 2's card has higher value, they win
    @Test
    public void testPlayPlayerTwoWins() {
        System.out.println("playPlayerTwoWins");
        ArrayList<WarCard> player1cards = new ArrayList<>();
        player1cards.add(new WarCard(SUITS[0], 4)); // card that matters
        player1cards.add(new WarCard(SUITS[0], 6));
        
        ArrayList<WarCard> player2cards = new ArrayList<>();
        player2cards.add(new WarCard(SUITS[0], 12)); // card that matters
        player2cards.add(new WarCard(SUITS[0], 2));
        
        WarPlayer player1 = new WarPlayer("player 1");
        WarPlayer player2 = new WarPlayer("player 2");
        // warGame automatically adds random cards to each player so
        // we're going to set the WarPile after we make the game
        WarGame warGame = new WarGame(20, player1, player2);
        player1.setWarPile(new WarPile(player1cards));
        player2.setWarPile(new WarPile(player2cards));
        
        warGame.play();
        // we'll know if the correct player won by looking at the sizes of the 
        // WarPile of player1 after a turn has been played. If he has gained a 
        // card, then he has won the turn
        int expResult = 1;
        int result = player1.getWarPile().getPileSize();
        assertEquals(result, expResult);
    }
    
    // player 1 and player 2 tie. player 1 wins the draw
    @Test
    public void testPlayPlayerOneWinsAfterTie() {
        System.out.println("playPlayerOneWinsAfterTie");
        ArrayList<WarCard> player1cards = new ArrayList<>();
        player1cards.add(new WarCard(SUITS[0], 4)); // first card that matters
        player1cards.add(new WarCard(SUITS[2], 6));
        player1cards.add(new WarCard(SUITS[1], 3));
        player1cards.add(new WarCard(SUITS[1], 4));
        player1cards.add(new WarCard(SUITS[3], 12)); // card that matters
        
        ArrayList<WarCard> player2cards = new ArrayList<>();
        player2cards.add(new WarCard(SUITS[3], 4)); // first card that matters
        player2cards.add(new WarCard(SUITS[2], 2));
        player2cards.add(new WarCard(SUITS[0], 12));
        player2cards.add(new WarCard(SUITS[0], 2));
        player2cards.add(new WarCard(SUITS[2], 5)); // card that matters
        
        WarPlayer player1 = new WarPlayer("player 1");
        WarPlayer player2 = new WarPlayer("player 2");
        // warGame automatically adds random cards to each player so
        // we're going to set the WarPile after we make the game
        WarGame warGame = new WarGame(20, player1, player2);
        player1.setWarPile(new WarPile(player1cards));
        player2.setWarPile(new WarPile(player2cards));
        
        warGame.play();
        // we'll know if the correct player won by looking at the sizes of the 
        // WarPile of player1 after a turn has been played. If he has gained 5 
        // cards, then he has won the turn after tieing
        int expResult = 10;
        int result = player1.getWarPile().getPileSize();
        assertEquals(result, expResult);
    }
    
    // player 1 and player 2 tie. player 1 wins the draw
    @Test
    public void testPlayPlayerTwoWinsAfterTie() {
        System.out.println("playPlayerTwoWinsAfterTie");
        ArrayList<WarCard> player1cards = new ArrayList<>();
        player1cards.add(new WarCard(SUITS[0], 4)); // first card that matters
        player1cards.add(new WarCard(SUITS[2], 6));
        player1cards.add(new WarCard(SUITS[1], 3));
        player1cards.add(new WarCard(SUITS[1], 4));
        player1cards.add(new WarCard(SUITS[3], 8)); // card that matters 
        
        ArrayList<WarCard> player2cards = new ArrayList<>();
        player2cards.add(new WarCard(SUITS[3], 4)); // first card that matters
        player2cards.add(new WarCard(SUITS[2], 2));
        player2cards.add(new WarCard(SUITS[0], 12));
        player2cards.add(new WarCard(SUITS[0], 2));
        player2cards.add(new WarCard(SUITS[2], 12)); // card that matters
        
        WarPlayer player1 = new WarPlayer("player 1");
        WarPlayer player2 = new WarPlayer("player 2");
        // warGame automatically adds random cards to each player so
        // we're going to set the WarPile after we make the game
        WarGame warGame = new WarGame(20, player1, player2);
        player1.setWarPile(new WarPile(player1cards));
        player2.setWarPile(new WarPile(player2cards));
        
        warGame.play();
        // we'll know if the correct player won by looking at the sizes of the 
        // WarPile of player1 after a turn has been played. If he has gained 5 
        // cards, then he has won the turn after tieing
        int expResult = 0;
        int result = player1.getWarPile().getPileSize();
        assertEquals(result, expResult);
    }
    
    // player 1 and player 2 tie. player 1 and player 2 tie again. 
    // player 1 wins the tiebreaker
    @Test
    public void testPlayPlayerOneWinsAfterTwoTies() {
        System.out.println("playPlayerOneWinsAfterTwoTies");
        ArrayList<WarCard> player1cards = new ArrayList<>();
        player1cards.add(new WarCard(SUITS[0], 4)); // first card that matters
        player1cards.add(new WarCard(SUITS[2], 6));
        player1cards.add(new WarCard(SUITS[1], 3));
        player1cards.add(new WarCard(SUITS[1], 4));
        player1cards.add(new WarCard(SUITS[3], 7)); // second card that matters 
        player1cards.add(new WarCard(SUITS[0], 5));
        player1cards.add(new WarCard(SUITS[2], 4));
        player1cards.add(new WarCard(SUITS[1], 2));
        player1cards.add(new WarCard(SUITS[0], 13)); // card that matters 
        
        ArrayList<WarCard> player2cards = new ArrayList<>();
        player2cards.add(new WarCard(SUITS[3], 4)); // first card that matters
        player2cards.add(new WarCard(SUITS[2], 2));
        player2cards.add(new WarCard(SUITS[0], 12));
        player2cards.add(new WarCard(SUITS[0], 2));
        player2cards.add(new WarCard(SUITS[2], 7)); // second card that matters
        player2cards.add(new WarCard(SUITS[1], 2));
        player2cards.add(new WarCard(SUITS[1], 12));
        player2cards.add(new WarCard(SUITS[3], 2));
        player2cards.add(new WarCard(SUITS[2], 3)); // card that matters
        
        WarPlayer player1 = new WarPlayer("player 1");
        WarPlayer player2 = new WarPlayer("player 2");
        // warGame automatically adds random cards to each player so
        // we're going to set the WarPile after we make the game
        WarGame warGame = new WarGame(20, player1, player2);
        player1.setWarPile(new WarPile(player1cards));
        player2.setWarPile(new WarPile(player2cards));
        
        warGame.play();
        // we'll know if the correct player won by looking at the sizes of the 
        // WarPile of player1 after a turn has been played. If he has gained 5 
        // cards, then he has won the turn after tieing
        int expResult = 18;
        int result = player1.getWarPile().getPileSize();
        assertEquals(result, expResult);
    }

    /**
     * Test of declareWinner method, of class WarGame.
     */
    @Test
    public void testDeclareWinnerPlayer1Wins() {
        System.out.println("declareWinnerPlayer1Wins");
        ArrayList<WarCard> player2cards = new ArrayList<>();
        player2cards.add(new WarCard(SUITS[3], 4));
        player2cards.add(new WarCard(SUITS[2], 2));
        
        WarPlayer player1 = new WarPlayer("p1");
        WarPlayer player2 = new WarPlayer("p2");
        WarGame instance = new WarGame(30, player1, player2);
        
        // set player2's card to player2cards
        // because player2 has less cards, player1 should win
        player2.setWarPile(new WarPile(player2cards));
        
        WarPlayer expResult = player1;
        WarPlayer result = instance.declareWinner();
        assertEquals(result, expResult);
    }
    
    @Test
    public void testDeclareWinnerPlayer2Wins() {
        System.out.println("declareWinnerPlayer2Wins");
        ArrayList<WarCard> player1cards = new ArrayList<>();
        player1cards.add(new WarCard(SUITS[3], 4));
        player1cards.add(new WarCard(SUITS[2], 2));
        
        WarPlayer player1 = new WarPlayer("p1");
        WarPlayer player2 = new WarPlayer("p2");
        WarGame instance = new WarGame(30, player1, player2);
        
        // set player1's card to player1cards
        // because player1 has less cards, player2 should win
        player1.setWarPile(new WarPile(player1cards));
        
        WarPlayer expResult = player2;
        WarPlayer result = instance.declareWinner();
        assertEquals(result, expResult);
    }
    
    @Test
    public void testDeclareWinnerTie() {
        System.out.println("declareWinnerTie");
        
        WarPlayer player1 = new WarPlayer("p1");
        WarPlayer player2 = new WarPlayer("p2");
        WarGame instance = new WarGame(30, player1, player2);
        
        // no turns have been played, so WarPile sizes are both 26
        WarPlayer expResult = null;
        WarPlayer result = instance.declareWinner();
        assertEquals(result, expResult);
    }

    /**
     * Test of canPlay method, of class WarGame.
     */
    @Test
    public void testCanPlayGood() {
        System.out.println("canPlayGood");
        WarGame instance = new WarGame(20, new WarPlayer("p1"), new WarPlayer("p2"));
        boolean expResult = true;
        boolean result = instance.canPlay();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCanPlayBad() {
        System.out.println("canPlayBad");
        WarGame instance = new WarGame(0, new WarPlayer("p1"), new WarPlayer("p2"));
        boolean expResult = false;
        boolean result = instance.canPlay();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCanPlayBoundary() {
        System.out.println("canPlayBoundary");
        WarGame instance = new WarGame(1, new WarPlayer("p1"), new WarPlayer("p2"));
        boolean expResult = true;
        boolean result = instance.canPlay();
        assertEquals(expResult, result);
    }
}
