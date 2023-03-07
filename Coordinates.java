package battleship;

import java.util.Scanner;

public class Coordinates {

    private int x = -1;
    private int y = -1;

    Coordinates(String input) {
        if (input.equals("")){
            input = getUserInput();
        }
        x = input.charAt(0) - 'A';
        y = Integer.parseInt(input.substring(1))-1;
        if (x < 0 || y < 0 || x > 9 || y > 9) {
            throw new Error("Error! You entered the wrong coordinates! Try again:");
        }
    }

    private String getUserInput() {
        Scanner in = new Scanner(System.in);
        System.out.println();
        String userInput = in.nextLine().trim().toUpperCase();
        System.out.println();
        return userInput;
    }

    Coordinates(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
