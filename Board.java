package battleship;

import java.util.List;

public class Board {
    private final int boardSize = 10;
    private final char waterSymbol = '~';
    private final char shipSymbol = 'O';
    private final char hitSymbol = 'X';
    private final char missSymbol = 'M';
    private char[][] boardArray;

    Board(){
        boardArray = new char[boardSize][boardSize];
    }

    public void printBoard(){
        for (int i = -1; i < boardSize; i++) {
            for (int j = -1; j < boardSize; j++) {
                if (i == -1 && j == -1) {
                    System.out.print(' ');
                } else if (i == -1) {
                    System.out.print(j+1);
                } else if (j == -1) {
                    char rowID = (char)(i + 'A');
                    System.out.print(rowID);
                } else {
                    System.out.print(boardArray[i][j]);
                }
                System.out.print(' ');
            }
            System.out.print("\n");
        }
        System.out.println();
    }

    public void showBoard(List<Ship> ships, List<Coordinates> misses) {
        cleanBoard();
        placeMisses(misses);
        placeShips(ships);
        printBoard();
    }

    private void cleanBoard() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                boardArray[i][j] = waterSymbol;
            }
        }
    }

    private void placeMisses(List<Coordinates> misses) {
        for ( Coordinates miss : misses ) {
            boardArray[miss.getX()][miss.getY()] = missSymbol;
        }
    }

    private void placeShips(List<Ship> ships) {
        for (Ship ship: ships) {
            if (ship != null){
                List<Coordinates> coordinates = ship.getCoordinates();
                boolean[] hits = ship.getHits();
                for (int i = 0; i < hits.length; i++) {
                    int x = coordinates.get(i).getX();
                    int y = coordinates.get(i).getY();
                    if (hits[i]) {
                        boardArray[x][y] = hitSymbol;
                    } else {
                        boardArray[x][y] = shipSymbol;
                    }
                }
            }
        }
    }
}
