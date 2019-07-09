package businesslogic;

import entities.Game;
import entities.HandPlayer;
import entities.Option;
import entities.Rounds;
import utils.GameUtils;
import utils.PlayerUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Games extends Game {

    private List<HandPlayer> handPlayers;
    private int numberOfPlayers;

    private static AtomicInteger atomicInteger = new AtomicInteger(1);

    private Games() {
        this.numberOfPlayers = 2;
        handPlayers = new ArrayList<>();
    }

    /**
     * Initialize method from where we start to play.
     */
    public static void play() {
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

    /**
     * This method hold the implementation logic for the first game.
     */
    public void playGameOne() {
        int gameOneNumberOfRounds = 100;
        Rounds.setNumberOfRounds(gameOneNumberOfRounds);

        //create handPlayers
        handPlayers = PlayerUtils.createPlayers(numberOfPlayers);

        handPlayers.forEach(e -> e.setName("Player " + atomicInteger.getAndIncrement()));

        //game one logic
        for (int i = 0; i < Rounds.getNumberOfRounds(); i++) {

            PlayerUtils.chooseRandomOption(handPlayers.get(0));
            handPlayers.get(1).setOption(Option.ROCK);
            System.out.println(handPlayers.get(0).getOption() + "  " + handPlayers.get(1).getOption());

            PlayerUtils.addPointToWinner(handPlayers.get(0), handPlayers.get(1));
        }

        //output of the first game
        System.out.println("====================\n" + handPlayers.get(0).getName() + " points: " + handPlayers.get(0).getPoints() +
                "\n" + handPlayers.get(1).getName() + " points: " + handPlayers.get(1).getPoints() + "\n====================");
        if (handPlayers.get(0).getPoints() > handPlayers.get(1).getPoints()) {
            System.out.println(handPlayers.get(0).getName() + " won the game!!!");
        } else if (handPlayers.get(1).getPoints() == handPlayers.get(0).getPoints()) {
            System.out.println("Draw!");
        } else {
            System.out.println(handPlayers.get(1).getName() + " won the game!!!");
        }
    }

    /**
     * This method hold the implementation logic for the second game.
     */
    public void playGameTwo() {
        Rounds.setNumberOfRounds(5);

        //create handPlayers
        handPlayers = PlayerUtils.createPlayers(numberOfPlayers);

        //play the game, make your choice, calculate the points for each player
        for (int i = 0; i < Rounds.getNumberOfRounds(); i++) {
            System.out.println("====================\nEnter: R -> for Rock, S -> for scissors, P -> for Paper");
            System.out.println("Please enter an option: ");
            String myChoice = GameUtils.setChoice();

            switch (myChoice) {
                case "R":
                    handPlayers.get(0).setOption(Option.ROCK);
                    break;
                case "S":
                    handPlayers.get(0).setOption(Option.SCISSORS);
                    break;
                case "P":
                    handPlayers.get(0).setOption(Option.PAPER);
                    break;
                default:
                    continue;
            }

            PlayerUtils.chooseRandomOption(handPlayers.get(1));

            PlayerUtils.addPointToWinner(handPlayers.get(0), handPlayers.get(1));
        }

        //printing out game results
        System.out.println("====================\nMy points: " + handPlayers.get(0).getPoints() + "\nMachine points: " + handPlayers.get(1).getPoints() + "\n====================");
        if (handPlayers.get(1).getPoints() > handPlayers.get(0).getPoints()) {
            System.out.println("Machine won the game!!!");
        } else if (handPlayers.get(1).getPoints() == handPlayers.get(0).getPoints()) {
            System.out.println("Draw!");
        } else {
            System.out.println("You won the game!!! Congratulations!!!");
        }
    }

}
