package battleship;

import java.util.*;

public class Battleship {

    private final int shipsNumber = 5;
    private Player player1;

    public Battleship(){
        player1 = new Player(shipsNumber);
        startGame();
    }

    private void startGame() {
        System.out.println("The game starts!");
        System.out.println();
        Board.showBoard(player1.getShips(), player1.getMisses(), true);
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
        for (Ship ship : player1.getShips()) {
            if (!ship.isSank()) {
                allSank = false;
                break;
            }
        }
        return allSank;
    }

    private void takeShot() {
        Coordinates shot = new Coordinates("");
        boolean hit = false;
        for (Ship s : player1.getShips()) {
            hit = s.checkShot(shot);
            if (hit) { break; }
        }
        if (hit) {
            Board.showBoard(player1.getShips(), player1.getMisses(), true);
            System.out.println("You hit a ship! Try again:");
        } else {
            player1.addMiss(shot);
            Board.showBoard(player1.getShips(), player1.getMisses(), true);
            System.out.println("You missed. Try again");
        }
        System.out.println();
    }

}
