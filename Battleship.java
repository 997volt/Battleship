package battleship;

import java.util.Arrays;

public class Battleship {

    private final int boardSize = 10;
    private char[][] field = new char[boardSize][boardSize];

    public Battleship(){
        resetBoard();
        showBoard();
    }

    private void resetBoard(){
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                field[i][j] = '~';
            }
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
                } else {
                    System.out.print(field[i][j] + " ");
                }
            }
            System.out.print("\n");
        }
    }

}
