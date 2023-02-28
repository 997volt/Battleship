package battleship;

import java.util.*;

public class Battleship {

    private final int[] shipsSizes = {5,4,3,3,2};
    private final String[] shipPrompts = {
            "Enter the coordinates of the Aircraft Carrier (5 cells):",
            "Enter the coordinates of the Battleship (4 cells):",
            "Enter the coordinates of the Submarine (3 cells):",
            "Enter the coordinates of the Cruiser (3 cells):",
            "Enter the coordinates of the Destroyer (2 cells):"
    };
    private Board gameboard;
    private Ship[] ships = new Ship[5];


    public Battleship(){
        gameboard = new Board();
        placeAllShips();
    }

    private void placeAllShips()
    {
        Scanner in = new Scanner(System.in);
        gameboard.showBoard();

        for (int i = 0; i < shipsSizes.length; i++) {
            System.out.println(shipPrompts[i]);
            System.out.println();
            ships[i] = new Ship(
                    in.nextLine().trim().toUpperCase(), shipsSizes[i]
            );
            gameboard.updateBoard(ships);
            gameboard.showBoard();
        }
    }
}
