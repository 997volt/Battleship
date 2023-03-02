package battleship;

import java.lang.reflect.Array;

public class Ship {
    private int[][] coordinates;

    public Ship(int[][] coordinates) {
        this.coordinates = coordinates;
    }

    public int[][] getCoordinates() {
        return coordinates;
    }

    public void checkCollision(Ship other){
        if (other == null) {
            return;
        }

        for (int[] c1: this.coordinates) {
            for (int[] c2: other.getCoordinates()) {
                int xDist = Math.abs(c1[0] - c2[0]);
                int yDist = Math.abs(c1[1] - c2[1]);
                if (xDist <= 1 && yDist <= 1){
                    throw new Error("Error! You placed it too close to another one. Try again:");
                }
            }
        }
    }
    
}
