package battleship;

import java.util.Scanner;

public class Coordinates {

    private int x = -1;
    private int y = -1;

    Coordinates() {
        System.out.println("Take a shot!");
        Scanner in = new Scanner(System.in);
        System.out.println();
        String userInput = in.nextLine().trim().toUpperCase();
        System.out.println();

        x = userInput.charAt(0) - 'A';
        y = Integer.parseInt(userInput.substring(1))-1;

        if (x < 0 || y < 0 || x > 9 || y > 9) {
            throw new Error("Error! You entered the wrong coordinates! Try again:");
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
