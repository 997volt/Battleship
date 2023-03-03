package battleship;

import java.util.*;

public class Battleship {

    private final int shipsNumber = 5;
    private Player player1;

    public Battleship(){
        player1 = new Player(shipsNumber);
        startGame();
    }

    private void startGame() {
        System.out.println("The game starts!");
        System.out.println();
        player1.showBoard();
        while (!player1.areAllSank()) {
            player1.takeShot();
        }
        System.out.println("You sank the last ship. You won. Congratulations!");
    }

}
