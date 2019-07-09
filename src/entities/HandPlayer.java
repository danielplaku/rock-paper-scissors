package entities;

public class HandPlayer implements Player{

    private int points = 0;
    private Option option;

    public HandPlayer() {
        super();
    }

    public int getPoints() {
        return points;
    }

    public void addPoint() {
        points++;
    }

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }
}
