package battleship;

public class Coordinates {
    private final int[][] coordinates;
    private int size = 1;
    private boolean isHorizontal;

    Coordinates(String userInput){
        setSize(userInput);
        coordinates = new int[size][2];
        setCoordinates(userInput);
    }

    void setSize(String userInput){
        String start = userInput.substring(0,2);
        String end = userInput.substring(3,5);
        for (int i = 0; i < 2; i++) {
            if (start.charAt(i) == end.charAt(i)) {
                isHorizontal = i == 0;
                size = Math.abs(
                        start.charAt(1 - i) - end.charAt(1 - i)
                ) + 1;
                return;
            }
        }
    }

    void setCoordinates(String userInput){
        for (int i = 0; i < size; i++) {
            coordinates[i][0] = userInput.charAt(0) - 'A';
            coordinates[i][1] = userInput.charAt(1) - '1';
            if (isHorizontal){
                coordinates[i][1] += i;
            } else {
                coordinates[i][0] += i;
            }
        }
    }

    public int[][] getCoordinates() {
        return coordinates;
    }
}
