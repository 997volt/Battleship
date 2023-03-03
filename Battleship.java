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
        gameboard.showBoard(ships, misses, true);
        while (!areAllSank()) {
            try{
                takeShot();
            } catch (Error e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("You sank the last ship. You won. Congratulations!");
    }

    private boolean areAllSank(){
        boolean allSank = true;
        for (Ship ship : ships) {
            if(!ship.isSank()) {
                allSank = false;
            }
        }
        return allSank;
    }

    private void takeShot() {
        Coordinates shot = new Coordinates("");
        boolean hit = false;
        for (Ship s : ships) {
            hit = s.checkShot(shot);
            if (hit) { break; }
        }
        if (hit) {
            gameboard.showBoard(ships, misses, true);
            System.out.println("You hit a ship! Try again:");
        } else {
            misses.add(shot);
            gameboard.showBoard(ships, misses, true);
            System.out.println("You missed. Try again");
        }
        System.out.println();
    }

    private void placeAllShips() {
        boolean print = true;
        ShipFactory shipFactory = new ShipFactory();
        gameboard.showBoard(ships, misses, false);

        for (int i = 0; i < shipsNumber;) {
            try{
                Ship newShip = shipFactory.CreateShip(i, print);
                ships.forEach((s) -> { newShip.checkCollision(s); });
                ships.add(newShip);
                gameboard.showBoard(ships, misses, false);
                print = true;
                i++;
            } catch (Error e) {
                System.out.println(e.getMessage());
                print = false;
            }
        }
    }

}
