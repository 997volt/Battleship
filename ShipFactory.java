package battleship;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShipFactory {

    private Scanner in = new Scanner(System.in);
    private final int[] shipsSizes = {5,4,3,3,2};
    private final String[] shipPrompts = {
            "Enter the coordinates of the Aircraft Carrier (5 cells):",
            "Enter the coordinates of the Battleship (4 cells):",
            "Enter the coordinates of the Submarine (3 cells):",
            "Enter the coordinates of the Cruiser (3 cells):",
            "Enter the coordinates of the Destroyer (2 cells):"
    };
    public ShipFactory(){}

    public Ship CreateShip(int shipNumber, boolean print){

        List<Coordinates> boardPoints = setBoardPoints(getUserInput(shipNumber, print));
        int size = getSize(shipNumber, boardPoints);
        List<Coordinates> coordinates = setCoordinates(size, boardPoints);

        return new Ship(coordinates);
    }

    private String[] getUserInput(int shipNumber, boolean print){
        if(print){
            System.out.println(shipPrompts[shipNumber]);
            System.out.println();
        }
        return in.nextLine().trim().toUpperCase().split(" ");
    }

    private List<Coordinates> setBoardPoints(String[] fields){
        List<Coordinates> coordinates = new ArrayList<Coordinates>();
        coordinates.add(new Coordinates(fields[0]));
        coordinates.add(new Coordinates(fields[1]));
        return coordinates;
    }

    private int getSize(int shipNumber, List<Coordinates> coordinates) {
        if (coordinates.get(0).getX() != coordinates.get(1).getX()
                && coordinates.get(0).getY() != coordinates.get(1).getY()){
            throw new Error("Error! Wrong ship location! Try again:");
        }
        int size = 0;
        int x = Math.abs(coordinates.get(0).getX() - coordinates.get(1).getX()) + 1;
        int y = Math.abs(coordinates.get(0).getY() - coordinates.get(1).getY()) + 1;
        size = Math.max(x, y);
        if (size != shipsSizes[shipNumber]){
            throw new Error("Error! Wrong length of the Submarine! Try again:");
        }
        return size;
    }

    private List<Coordinates> setCoordinates(int size, List<Coordinates> boardPoints) {
        List<Coordinates> coordinates = new ArrayList<Coordinates>();

        int xStart = Math.min(boardPoints.get(0).getX(), boardPoints.get(1).getX());
        int yStart = Math.min(boardPoints.get(0).getY(), boardPoints.get(1).getY());

        for (int i = 0; i < size; i++) {
            if (boardPoints.get(0).getX() == boardPoints.get(1).getX()) {
                coordinates.add( new Coordinates(xStart, yStart + i));
            } else {
                coordinates.add( new Coordinates(xStart + i, yStart));
            }
        }

        return coordinates;
    }
}
