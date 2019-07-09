package entities;

public enum Option {

    ROCK("R"), PAPER("P"), SCISSORS("S");

    private final String choice;

    Option(String option) {
        this.choice = option;
    }

    @Override
    public String toString() {
        return choice;
    }
}
