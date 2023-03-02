package battleship;

import java.lang.reflect.Array;

public class Ship {
    private int[][] coordinates;
    private boolean[] hits;

    public Ship(int[][] coordinates) {
        this.coordinates = coordinates;
        this.hits = new boolean[coordinates.length];
        for (boolean hit: hits) { hit = false; }
    }

    public int[][] getCoordinates() {
        return coordinates;
    }

    public boolean[] getHits() {
        return hits;
    }

    public void checkCollision(Ship other){
        if (other == null) { return; }

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

    public boolean checkShot(Coordinates shot) {
        boolean hit = false;
        for (int i = 0; i < coordinates.length; i++) {
            if (shot.getX() == coordinates[i][0] && shot.getY() == coordinates[i][1]) {
                hits[i] = true;
                hit = true;
            }
        }
        return hit;
    }
}
