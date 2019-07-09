package utils;

import entities.HandPlayer;
import entities.Option;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PlayerUtils {

    private static Random random = new Random();

    public PlayerUtils() {
    }

    public static void chooseRandomOption(HandPlayer handPlayer) {

        int randNumber = random.nextInt(3);
        System.out.println("Rand number: " + randNumber);

        if (randNumber == 0) {
            handPlayer.setOption(Option.ROCK);
        } else if (randNumber == 1) {
            handPlayer.setOption(Option.SCISSORS);
        } else {
            handPlayer.setOption(Option.PAPER);
        }
    }

    /**
     * This method takes 2 players as parameters and add one point to one of them.
     *
     * @param handPlayer1 first player
     * @param handPlayer2 second player
     */
    public static void addPointToOnePlayer(HandPlayer handPlayer1, HandPlayer handPlayer2) {

        if (handPlayer1.getOption().equals(handPlayer2.getOption())) {
            return;
        }
        if (handPlayer1.getOption().equals(Option.ROCK)) {
            if (handPlayer2.getOption().equals(Option.SCISSORS)) {
                handPlayer1.addPoint();
                return;
            }
            if (handPlayer2.getOption().equals(Option.PAPER)) {
                handPlayer2.addPoint();
                return;
            }
        }
        if (handPlayer1.getOption().equals(Option.SCISSORS)) {
            if (handPlayer2.getOption().equals(Option.PAPER)) {
                handPlayer1.addPoint();
                return;
            }
            if (handPlayer2.getOption().equals(Option.ROCK)) {
                handPlayer2.addPoint();
                return;
            }
        }
        if (handPlayer1.getOption().equals(Option.PAPER)) {
            if (handPlayer2.getOption().equals(Option.ROCK)) {
                handPlayer1.addPoint();
                return;
            }
            if (handPlayer2.getOption().equals(Option.SCISSORS)) {
                handPlayer2.addPoint();
            }
        }
    }

    /**
     * This method create a list of players.
     *
     * @param numberOfPlayers number of players as int
     * @return list of players
     */
    public static List<HandPlayer> createPlayers(int numberOfPlayers) {
        List<HandPlayer> handPlayers = new ArrayList<>();
        //create player objects
        for (int i = 0; i < numberOfPlayers; i++) {
            handPlayers.add(new HandPlayer());
        }

        return handPlayers;
    }
}
