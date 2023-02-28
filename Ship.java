package battleship;

public class Ship {

    private Coordinates coordinates;

    public Ship(String userInput, int size){
        coordinates = new Coordinates(userInput);
    }

    public int[][] getCoordinates() {
        return coordinates.getCoordinates();
    }
}
