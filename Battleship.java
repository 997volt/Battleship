package battleship;

import java.util.*;

public class Battleship {

    private final int shipsNumber = 5;
    private Board gameboard;
    private Ship[] ships = new Ship[shipsNumber];


    public Battleship(){
        gameboard = new Board();
        placeAllShips();
    }

    private void placeAllShips()
    {
        ShipFactory shipFactory = new ShipFactory();
        gameboard.showBoard();

        for (int i = 0; i < shipsNumber; i++) {

            ships[i] = shipFactory.CreateShip(i);
            gameboard.updateBoard(ships);
        }
    }
}
