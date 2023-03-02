package battleship;

import java.util.*;

public class Battleship {

    private final int shipsNumber = 5;
    private Board gameboard;
    private List<Ship> ships = new ArrayList<Ship>();
    private List<int[]> misses = new ArrayList<int[]>();

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
        int[] shot = getShotCoordinates();
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

    private int[] getShotCoordinates() {
        int[] shot = new int[2];
        System.out.println("Take a shot!");
        Scanner in = new Scanner(System.in);
        System.out.println();
        String userInput = in.nextLine().trim().toUpperCase();
        System.out.println();
        shot[0] = userInput.charAt(0) - 'A';
        if(userInput.length() == 2){
            shot[1] = userInput.charAt(1) - '1';
        } else if (userInput.length() == 3 && userInput.substring(1,3).equals("10")) {
            shot[1] = 9;
        } else {
            throw new Error("Error! You entered the wrong coordinates! Try again:");
        }
        if (shot[0] > 9 || shot[0] < 0) {
            throw new Error("Error! You entered the wrong coordinates! Try again:");
        }
        return shot;
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
