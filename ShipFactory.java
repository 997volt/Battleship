package battleship;

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

        int[][] boardPoints = setBoardPoints(getUserInput(shipNumber, print));
        boolean isHorizontal = setIsHorizontal(boardPoints);
        int size = getSize(shipNumber, isHorizontal, boardPoints);
        int[][] coordinates = setCoordinates(isHorizontal, size, boardPoints);

        return new Ship(coordinates);
    }

    private String[] getUserInput(int shipNumber, boolean print){
        if(print){
            System.out.println(shipPrompts[shipNumber]);
            System.out.println();
        }
        return in.nextLine().trim().toUpperCase().split(" ");
    }

    private int[][] setBoardPoints(String[] fields){
        int[][] coordinates = { {-1, -1}, {-1, -1} };
        for (int i = 0; i < 2; i++) {
            coordinates[i][0] = fields[i].charAt(0) - 'A';
            if(fields[i].length() == 2){
                coordinates[i][1] = fields[i].charAt(1) - '1';
            } else if (fields[i].length() == 3 && fields[i].substring(1,3).equals("10")) {
                coordinates[i][1] = 9;
            } else {
                throw new Error("Error! Wrong input! Try again:"); // TODO: change message
            }
        }
        return coordinates;
    }

    private boolean setIsHorizontal(int[][] coordinates) {
        if (coordinates[0][0] == coordinates[1][0]){
            return true;
        } else if (coordinates[0][1] == coordinates[1][1]) {
            return false;
        } else {
            throw new Error("Error! Wrong ship location! Try again:");
        }
    }

    private int getSize(int shipNumber, boolean isHorizontal, int[][] c) {
        int size = 0;

        if (isHorizontal){
            size = Math.abs(c[0][1] - c[1][1]) + 1;
        } else {
            size = Math.abs(c[0][0] - c[1][0]) + 1;
        }

        if (size != shipsSizes[shipNumber]){
            throw new Error("Error! Wrong length of the Submarine! Try again:");
        }

        return size;
    }

    private int[][] setCoordinates(boolean isHorizontal, int size, int[][] boardPoints) {
        int[][] coordinates = new int[size][2];

        for (int i = 0; i < size; i++) {
            if ( isHorizontal ){
                coordinates[i][0] = boardPoints[0][0];
                if (boardPoints[0][1] < boardPoints[1][1]){
                    coordinates[i][1] = boardPoints[0][1] + i;
                } else {
                    coordinates[i][1] = boardPoints[1][1] + i;
                }
            } else {
                coordinates[i][1] = boardPoints[1][1];
                if (boardPoints[0][0] < boardPoints[1][0]){
                    coordinates[i][0] = boardPoints[0][0] + i;
                } else {
                    coordinates[i][0] = boardPoints[1][0] + i;
                }
            }
        }

        return coordinates;
    }
}
