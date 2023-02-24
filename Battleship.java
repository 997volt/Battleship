package battleship;

import java.util.Scanner;

public class Battleship {

    private final int boardSize = 10;
    private final int[][] field = new int[boardSize][boardSize];
    private final Ship[] ships = new Ship[5];

    public Battleship(){
        resetBoard();
        placeAllShips();
    }

    private void resetBoard(){
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                field[i][j] = '0';
            }
        }
    }

    private void updateBoard(){
        for (Ship s : ships ) {
            s.checkShip("");
            field[0][0] = 10;
        }
    }

    private void showBoard(){
        for (int i = -1; i < boardSize; i++) {
            for (int j = -1; j < boardSize; j++) {
                if (i == -1 && j == -1) {
                    System.out.print("  ");
                } else if (i == -1) {
                    System.out.print(j+1 + " ");
                } else if (j == -1) {
                    char rowID = (char)(i + 'A');
                    System.out.print(rowID + " ");
                } else if (field[i][j] > 10) {
                    System.out.print("O ");
                } else {
                    System.out.print("~ ");
                }
            }
            System.out.print("\n");
        }
        System.out.println();
    }

    private void placeAllShips()
    {
        Scanner in = new Scanner(System.in);
        showBoard();
        System.out.println("Enter the coordinates of the Aircraft Carrier (5 cells):");
        System.out.println();
        ships[0] = new Ship(in.nextLine(),5);
        updateBoard();
        System.out.println();
        showBoard();
    }
}
