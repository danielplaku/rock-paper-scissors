package playgame;

import entities.Games;
import utils.GameUtils;

public class Main {

    public static void main(String[] args) {
//Game.play()

        Games game = new Games();

        System.out.println("Which game you wanna play?");
        System.out.println("Enter: 1 -> for game one, 2 -> for game two.");

        int gameNumber = GameUtils.getGameNumber();

        if (gameNumber == 1) {
            game.playGameOne();
        } else if (gameNumber == 2) {
            game.playGameTwo();
        }
    }
}
