package battleship;

import java.util.List;

public class Board {
    private final int boardSize = 10;
    private final char waterSymbol = '~';
    private final char shipSymbol = 'O';
    private final char hitSymbol = 'X';
    private final char missSymbol = 'M';
    private int[][] boardArray;

    Board(){
        boardArray = new int[boardSize][boardSize];
        resetBoard();
    }

    private void resetBoard(){
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                boardArray[i][j] = 0;
            }
        }
    }

    public void showBoard(){
        for (int i = -1; i < boardSize; i++) {
            for (int j = -1; j < boardSize; j++) {
                if (i == -1 && j == -1) {
                    System.out.print(' ');
                } else if (i == -1) {
                    System.out.print(j+1);
                } else if (j == -1) {
                    char rowID = (char)(i + 'A');
                    System.out.print(rowID);
                } else if (boardArray[i][j] == 10){
                    System.out.print(shipSymbol);
                } else {
                    System.out.print(waterSymbol);
                }
                System.out.print(' ');
            }
            System.out.print("\n");
        }
        System.out.println();
    }


    public void updateBoard(List<Ship> ships) {
        for (Ship ship: ships) {
            if (ship != null){
                int[][] coordinates = ship.getCoordinates();
                for ( int[] c : coordinates ) {
                    boardArray[c[0]][c[1]] = 10;
                }
            }
        }
        showBoard();
    }
}
