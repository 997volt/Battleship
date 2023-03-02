package battleship;

import java.util.*;

public class Battleship {

    private final int shipsNumber = 5;
    private Board gameboard;
    private List<Ship> ships = new ArrayList<Ship>();
    private List<Coordinates> misses = new ArrayList<Coordinates>();

    public Battleship(){
        gameboard = new Board();
        placeAllShips();
        startGame();
    }

    private void startGame() {
        System.out.println("The game starts!");
        System.out.println();
        gameboard.showBoard();
        while (true) {
            try{
                takeShot();
            } catch (Error e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void takeShot() {
        Coordinates shot = new Coordinates("");
        boolean hit = false;
        for (Ship s : ships) {
            hit = s.checkShot(shot);
            if (hit) { break; }
        }
        if (hit) {
            System.out.println("You hit a ship!");
        } else {
            misses.add(shot);
            System.out.println("You missed!");
        }
        System.out.println();
        gameboard.takeShot(ships, misses);
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
                gameboard.placeShip(ships);
                print = true;
                i++;
            } catch (Error e) {
                System.out.println(e.getMessage());
                print = false;
            }
        }
    }

}
