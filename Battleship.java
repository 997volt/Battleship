package battleship;

import java.util.*;

public class Battleship {

    private final int shipsNumber = 5;
    private Player player1;
    private Player player2;

    public Battleship() {
        player1 = new Player(1, shipsNumber);
        player2 = new Player(2, shipsNumber);

        while (!player1.areAllSank() && !player2.areAllSank()) {
            Board.showBoards(1, player1, player2);
            player2.takeShot();
            Board.showBoards(2, player2, player1);
            player1.takeShot();
        }
    }
}
