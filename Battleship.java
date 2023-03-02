package battleship;

import java.util.*;

public class Battleship {

    private final int shipsNumber = 5;
    private Board gameboard;
    private List<Ship> ships = new ArrayList<Ship>();


    public Battleship(){
        gameboard = new Board();
        placeAllShips();
    }

    private void placeAllShips()
    {
        boolean print = true;
        ShipFactory shipFactory = new ShipFactory();
        gameboard.showBoard();

        for (int i = 0; i < shipsNumber;) {
            try{
                Ship newShip = shipFactory.CreateShip(i, print);
                ships.forEach((s) -> { newShip.checkCollision(s); });
                ships.add(newShip);
                gameboard.updateBoard(ships);
                print = true;
                i++;
            } catch (Error e) {
                System.out.println(e.getMessage());
                print = false;
            }
        }
    }

}
