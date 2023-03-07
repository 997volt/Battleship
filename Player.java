package battleship;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {

    private List<Ship> ships;
    private List<Coordinates> misses;

    Player(int playerNumber, int shipsNumber) {
        ships = new ArrayList<Ship>();
        misses = new ArrayList<Coordinates>();
        boolean print = true;
        ShipFactory shipFactory = new ShipFactory();

        System.out.println(String.format("Player %d, place your ships on the game field", playerNumber));
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
        System.out.println("Press Enter and pass the move to another player");
        new Scanner(System.in).nextLine();
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
                System.out.println("You hit a ship!");
            } else {
                addMiss(shot);
                System.out.println("You missed.");
            }
        } catch (Error e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
        if (areAllSank()){
            System.out.println("You sank the last ship. You won. Congratulations!");
        }
        else {
            System.out.println("Press Enter and pass the move to another player");
            new Scanner(System.in).nextLine();
        }
    }

}
