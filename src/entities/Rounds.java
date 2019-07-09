package entities;

public class Rounds {

    private Rounds() {
    }

    private static int numberOfRounds;

    public static int getNumberOfRounds() {
        return numberOfRounds;
    }

    public static void setNumberOfRounds(int roundNumbers) {
        numberOfRounds = roundNumbers;
    }
}
