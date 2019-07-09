package entities;

public class HandPlayer extends Player {

    private String name;
    private int points = 0;
    private Option option;

    public HandPlayer() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
