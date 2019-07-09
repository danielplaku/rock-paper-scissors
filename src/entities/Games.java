package entities;

import utils.GameUtils;
import utils.PlayerUtils;

import java.util.ArrayList;
import java.util.List;

public class Games extends Game{

    private List<HandPlayer> handPlayers;
    private int numberOfPlayers;

    public Games() {
        this.numberOfPlayers = 2;
        handPlayers = new ArrayList<>();
    }

    /**
     * This method hold the implementation logic for the first game.
     *
     */
    public void playGameOne() {
        int gameOneNumberOfRounds = 100;
        Rounds.setNumberOfRounds(gameOneNumberOfRounds);

        //create handPlayers
        handPlayers = PlayerUtils.createPlayers(numberOfPlayers);

        //game one logic
        for (int i = 0; i < Rounds.getNumberOfRounds(); i++) {

            PlayerUtils.chooseRandomOption(handPlayers.get(0));
            handPlayers.get(1).setOption(Option.ROCK);
            System.out.println(handPlayers.get(0).getOption()+ "  " + handPlayers.get(1).getOption());

            PlayerUtils.addPointToOnePlayer(handPlayers.get(0), handPlayers.get(1));
        }

        //output of the first game
        System.out.println("====================\nHandPlayer 1 points: " + handPlayers.get(0).getPoints() + "\nHandPlayer 2 points: " + handPlayers.get(1).getPoints() + "\n====================");
        if (handPlayers.get(0).getPoints() > handPlayers.get(1).getPoints()) {
            System.out.println("HandPlayer 1 won the game!!!");
        } else if (handPlayers.get(1).getPoints() == handPlayers.get(0).getPoints()) {
            System.out.println("Draw!");
        } else {
            System.out.println("HandPlayer 2 won the game!!!");
        }
    }

    public void playGameTwo() {
        Rounds.setNumberOfRounds(5);

        //create handPlayers
        handPlayers = PlayerUtils.createPlayers(numberOfPlayers);

        //play the game, make your choice, calculate the points for each player
        for (int i=0; i<Rounds.getNumberOfRounds(); i++) {
            System.out.println("====================\nEnter: R -> for Rock, S -> for scissors, P -> for Paper");
            System.out.println("Please enter an option: ");
            String myChoice = GameUtils.setChoice();

            if (myChoice.equals("R")) {
                handPlayers.get(0).setOption(Option.ROCK);
            } else if (myChoice.equals("S")) {
                handPlayers.get(0).setOption(Option.SCISSORS);
            } else if (myChoice.equals("P")) {
                handPlayers.get(0).setOption(Option.PAPER);
            }
            PlayerUtils.chooseRandomOption(handPlayers.get(1));

            PlayerUtils.addPointToOnePlayer(handPlayers.get(0), handPlayers.get(1));
        }

        //printing out game results
        System.out.println("====================\nMy points: " + handPlayers.get(0).getPoints()+"\nMachine points: " + handPlayers.get(1).getPoints()+ "\n====================");
        if (handPlayers.get(1).getPoints() > handPlayers.get(0).getPoints()) {
            System.out.println("Machine won the game!!!");
        } else if (handPlayers.get(1).getPoints() == handPlayers.get(0).getPoints()) {
            System.out.println("Draw!");
        } else {
            System.out.println("You won the game!!! Congratulations!!!");
        }
    }

}
