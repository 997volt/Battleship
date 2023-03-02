package battleship;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Ship {

    private boolean[] hits;

    private List<Coordinates> coordinates = new ArrayList<Coordinates>();

    public Ship(List<Coordinates> coordinates) {
        this.coordinates = coordinates;
        this.hits = new boolean[coordinates.size()];
        for (boolean hit: hits) { hit = false; }
    }

    public List<Coordinates> getCoordinates() {
        return coordinates;
    }

    public boolean[] getHits() {
        return hits;
    }

    public void checkCollision(Ship other){
        if (other == null) { return; }

        for (Coordinates c1: this.coordinates) {
            for (Coordinates c2: other.getCoordinates()) {
                int xDist = Math.abs(c1.getX() - c2.getX());
                int yDist = Math.abs(c1.getY() - c2.getY());
                if (xDist <= 1 && yDist <= 1){
                    throw new Error("Error! You placed it too close to another one. Try again:");
                }
            }
        }
    }

    public boolean checkShot(Coordinates shot) {
        boolean hit = false;
        for (int i = 0; i < coordinates.size(); i++) {
            if (shot.getX() == coordinates.get(i).getX() && shot.getY() == coordinates.get(i).getY()) {
                hits[i] = true;
                hit = true;
            }
        }
        return hit;
    }
}
