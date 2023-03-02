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
        boolean print = true;

        for (int i = 0; i < shipsNumber;) {
            try{
                Ship newShip = shipFactory.CreateShip(i, print);
                for (Ship s: ships) {
                    newShip.checkCollision(s);
                }
                ships[i] = newShip;
                gameboard.updateBoard(ships);
                gameboard.showBoard();
                print = true;
                i++;
            } catch (Error e) {
                System.out.println(e.getMessage());
                print = false;
            }

        }
    }

}
