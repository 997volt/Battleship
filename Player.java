package battleship;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<Ship> ships = new ArrayList<Ship>();
    private List<Coordinates> misses = new ArrayList<Coordinates>();

    Player(int shipsNumber) {
        boolean print = true;
        ShipFactory shipFactory = new ShipFactory();
        Board.showBoard(ships, misses, false);

        for (int i = 0; i < shipsNumber;) {
            try{
                Ship newShip = shipFactory.CreateShip(i, print);
                ships.forEach((s) -> { newShip.checkCollision(s); });
                ships.add(newShip);
                Board.showBoard(ships, misses, false);
                print = true;
                i++;
            } catch (Error e) {
                System.out.println(e.getMessage());
                print = false;
            }
        }
    }

    public List<Coordinates> getMisses() {
        return misses;
    }

    public List<Ship> getShips() {
        return ships;
    }

    private void addMiss(Coordinates miss){
        misses.add(miss);
    }

    public void showBoard() {
        Board.showBoard(ships, misses, true);
    }

    public boolean areAllSank(){
        boolean allSank = true;
        for (Ship ship : ships) {
            if (!ship.isSank()) {
                allSank = false;
                break;
            }
        }
        return allSank;
    }

    public void takeShot() {
        Coordinates shot = new Coordinates("");
        boolean hit = false;
        try{
            for (Ship s : ships) {
                hit = s.checkShot(shot);
                if (hit) { break; }
            }
            if (hit) {
                showBoard();
                System.out.println("You hit a ship! Try again:");
            } else {
                addMiss(shot);
                showBoard();
                System.out.println("You missed. Try again");
            }
        } catch (Error e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
    }

}
