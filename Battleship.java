package battleship;

import java.util.*;

public class Battleship {

    private final int shipsNumber = 5;
    private Player player1;
    private Player player2;
    private Scanner in = new Scanner(System.in);

    public Battleship() {
        System.out.println("Player 1, place your ships on the game field");
        player1 = new Player(shipsNumber);
        System.out.println("Press Enter and pass the move to another player");
        in.nextLine();
        System.out.println("Player 2, place your ships to the game field");
        player2 = new Player(shipsNumber);
        System.out.println("Press Enter and pass the move to another player");
        in.nextLine();
        startGame();
    }

    private void startGame() {
        player1.showBoard();
        while (!player1.areAllSank() && !player2.areAllSank()) {
            System.out.println();
            System.out.println("Player 1, it's your turn:");
            System.out.println();
            Board.showBoards(player1, player2);
            player2.takeShot();
            System.out.println("Press Enter and pass the move to another player");
            in.nextLine();
            System.out.println();
            System.out.println("Player 2, it's your turn:");
            System.out.println();
            Board.showBoards(player2, player1);
            player1.takeShot();
            System.out.println("Press Enter and pass the move to another player");
            in.nextLine();
        }
    }

}
