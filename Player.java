package battleship;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {

    private List<Ship> ships = new ArrayList<Ship>();
    private List<Coordinates> misses = new ArrayList<Coordinates>();
    private Scanner in = new Scanner(System.in);

    Player(int playerNumber, int shipsNumber) {
        ShipFactory shipFactory = new ShipFactory();
        String errorMessage = "";

        System.out.println(String.format("Player %d, place your ships on the game field", playerNumber));
        Board.showBoard(ships, misses, false);

        for (int i = 0; i < shipsNumber;) {
            try{
                Ship newShip = shipFactory.CreateShip(i, errorMessage);
                ships.forEach((s) -> { newShip.checkCollision(s); });
                ships.add(newShip);
                Board.showBoard(ships, misses, false);
                errorMessage = "";
                i++;
            } catch (Error e) {
                errorMessage = e.getMessage();
            }
        }

        System.out.println("Press Enter and pass the move to another player");
        in.nextLine();
    }

    public List<Coordinates> getMisses() {
        return misses;
    }

    public List<Ship> getShips() {
        return ships;
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

        if (isHit(shot)) {
            System.out.println("You hit a ship!");
            if (areAllSank()){
                System.out.println("You sank the last ship. You won. Congratulations!");
                in.nextLine();
            }
        } else {
            misses.add(shot);
            System.out.println("You missed.");
        }

        System.out.println("Press Enter and pass the move to another player");
        in.nextLine();
    }

    private boolean isHit(Coordinates shot) {
        boolean hit = false;
        for (Ship s : ships) {
            if (s.checkShot(shot)) {
                hit = true;
                break;
            }
        }
        return hit;
    }
}
