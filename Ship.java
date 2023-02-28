package battleship;

public class Ship {
    private int[][] coordinates;

    public Ship(int[][] coordinates) {
        this.coordinates = coordinates;
    }

    public int[][] getCoordinates() {
        return coordinates;
    }
}
