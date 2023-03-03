package battleship;

import java.util.List;

public class Board {
    private static final int boardSize = 10;
    private static final char waterSymbol = '~';
    private static final char shipSymbol = 'O';
    private static final char hitSymbol = 'X';
    private static final char missSymbol = 'M';
    private static char[][] boardArray;

    public static void showBoard(List<Ship> ships, List<Coordinates> misses, boolean fogOfWar) {
        cleanBoard();
        placeMisses(misses);
        placeShips(ships, fogOfWar);
        printBoard();
    }

    private static void cleanBoard() {
        boardArray = new char[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                boardArray[i][j] = waterSymbol;
            }
        }
    }

    private static void placeMisses(List<Coordinates> misses) {
        for ( Coordinates miss : misses ) {
            boardArray[miss.getX()][miss.getY()] = missSymbol;
        }
    }

    private static void placeShips(List<Ship> ships, boolean fogOfWar) {
        for (Ship ship: ships) {
            if (ship != null) {
                List<Coordinates> coordinates = ship.getCoordinates();
                boolean[] hits = ship.getHits();
                for (int i = 0; i < hits.length; i++) {
                    int x = coordinates.get(i).getX();
                    int y = coordinates.get(i).getY();
                    if (hits[i]) {
                        boardArray[x][y] = hitSymbol;
                    } else if (!fogOfWar) {
                        boardArray[x][y] = shipSymbol;
                    }
                }
            }
        }
    }

    private static void printBoard(){
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

}
