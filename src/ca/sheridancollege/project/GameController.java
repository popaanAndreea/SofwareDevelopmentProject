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
            System.out.println("Press enter to start:");
            input.nextLine();
            System.out.println();
            warGame.play();
            System.out.println();
        }
        warGame.declareWinner();

        // thank the user for playing
        System.out.println("\n Thanks For Playing our Game!");
    }
}
