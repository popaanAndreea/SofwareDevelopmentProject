package ca.sheridancollege.project;

import java.util.Scanner;

/**
 * A class that takes in user input to create a specific game of war and lets
 * a user play the game to completion.
 * @author fernandofedele
 */
public class GameController {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to War!\n\n");
        int numPlayers = 2;

        // create 2 WarPlayers
        System.out.print("Enter a name for player 1: ");
        String name = input.nextLine();
        WarPlayer player1 = new WarPlayer(name);
        System.out.print("Enter a name for player 2: ");
        name = input.nextLine();
        WarPlayer player2 = new WarPlayer(name);

        // ask how many turns the game will be
        System.out.print("\nHow many turns will the game last? : ");
        int numTurns = input.nextInt();

        input.nextLine(); // eat the newline from last use of scanner
        
        // create a WarGame with given numTurns and warPlayers
        WarGame warGame = new WarGame(numTurns, player1, player2);
        System.out.println("\nGame is Starting!\n");
        while (warGame.canPlay()) {
            System.out.println("Turn " + warGame.getTurnNum() + " is starting.");
            System.out.println(warGame.getPlayer1().displayNumCardsLeft());
            System.out.println(warGame.getPlayer2().displayNumCardsLeft());
            System.out.println("Press enter to play:");
            input.nextLine();
            System.out.println();
            warGame.play();
            System.out.println();
        }
        WarPlayer winner = warGame.declareWinner();

        if (winner == null) {
            System.out.println(player1.getPlayerID() + " and " + player2.getPlayerID() + " have tied.");;
        } else if (player1.equals(winner)) {
            System.out.println(player1.getPlayerID() + " has won the game. Congratulations!");
        } else {
            System.out.println(player2.getPlayerID() + " has won the game. Congratulations!");
        }
        // thank the user for playing
        System.out.println("\nThanks For Playing our Game!");
    }
}
