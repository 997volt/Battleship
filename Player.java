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

    public void addMiss(Coordinates miss){
        misses.add(miss);
    }

}
