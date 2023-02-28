package battleship;

public class Coordinates {
    private final int[][] coordinates;
    private int size = 1;
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
                size = Math.abs(
                        start.charAt(1 - i) - end.charAt(1 - i)
                );
                return;
            }
        }
    }

    void setCoordinates(String userInput){
        coordinates[0][0] = 0;
    }

    public int[][] getCoordinates() {
        return coordinates;
    }
}
