package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author fernandofedele
 */
public class GameController {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to War!\n\n");
        int numPlayers = 0;
        while (numPlayers > 4 || numPlayers < 2) {
            System.out.print("Between 2 and 4 players can play, how many are playing? : ");
            numPlayers = input.nextInt();
        }
        input.nextLine(); // eat extra newline 
        System.out.println();
        
        // create an empty array of WarPlayers, populate it with players based
        // on given names
        ArrayList<WarPlayer> warPlayers = new ArrayList<>();
        for (int i=1; i <= numPlayers; i++) {
            System.out.print("Enter a name for player " + i + " : ");
            String name = input.nextLine();
            warPlayers.add(new WarPlayer(name));
        }
        
        System.out.println(warPlayers);
        
    }
}
