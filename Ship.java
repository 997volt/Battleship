package battleship;

public class Ship {

    private String coordinate1 = "";
    private String coordinate2 = "";

    public Ship(String coordinates, int size){
        coordinates = coordinates.trim().toUpperCase();
        if(coordinates.length() != 5){
            System.out.println("Wrong input");
        }
        else {
            coordinate1 = coordinates.substring(0,2);
            coordinate2 = coordinates.substring(3,5);
        }
        calculateDistance(size);
    }

    private void calculateDistance(int expectedSize){
        int a = 0, b = 0;
        for (int i = 0; i < 2; i++) {
            if (coordinate1.charAt(i) == coordinate2.charAt(i)) {
                a = coordinate1.charAt(1 - i);
                b = coordinate2.charAt(1 - i);
            }
        }
        if (Math.abs(a - b) != expectedSize){
            System.out.println("Wrong ship size!");
        }
    }

    public boolean checkShip(String coordinate){
        return coordinate.equals("");
    }
}
