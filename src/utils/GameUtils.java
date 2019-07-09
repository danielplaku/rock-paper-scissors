package utils;

import java.util.Scanner;

public class GameUtils {

    private GameUtils() {
    }

    /**
     * This method obliges the user to enter 1 or 2 as input from the keyboard and return that number.
     *
     * @return number 1 or 2
     */
    public static int getGameNumber() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Insert game number:");
            try {
                int number = input.nextInt();

                if (number == 1 || number == 2) {
                    return number;
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Please, enter a valid game number.");
                System.out.println("Enter: 1 -> for game one, 2 -> for game two.");
                input.nextLine();
            }
        }
    }

    /**
     * This method obliges the user to enter "R", "S" or "P" as input from the keyboard and return that string.
     *
     * @return string R S or P
     */
    public static String setChoice() {
        Scanner input = new Scanner(System.in);

        while (true) {
            String choice = input.next();

            if (choice.matches("[RSP]")) {
                return choice;
            }

            System.out.println("Please, enter a valid option!");
            input.nextLine();
        }
    }
}
