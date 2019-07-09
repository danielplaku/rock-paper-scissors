package entities;

public class Rounds implements HasRounds{

    private Rounds() {
    }

    private static int numberOfRounds;

    public boolean hasRounds(boolean hasRounds) {
        return hasRounds;
    }

    public static int getNumberOfRounds() {
        return numberOfRounds;
    }

    public static void setNumberOfRounds(int roundNumbers) {
        numberOfRounds = roundNumbers;
    }
}
