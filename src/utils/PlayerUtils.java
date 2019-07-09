package utils;

import entities.HandPlayer;
import entities.Option;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PlayerUtils {

    private static Random random = new Random();
    private static ArrayList<String> options = new ArrayList<>((Arrays.asList("R", "S", "P")));

    private PlayerUtils() {
    }

    /**
     * This method help to generate a random choice for the player <code>handPlayer</code>.
     * @param handPlayer player
     */
    public static void chooseRandomOption(HandPlayer handPlayer) {

        int randNumber = random.nextInt(3);

        if (randNumber == 0) {
            handPlayer.setOption(Option.ROCK);
        } else if (randNumber == 1) {
            handPlayer.setOption(Option.SCISSORS);
        } else {
            handPlayer.setOption(Option.PAPER);
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

    /**
     * This method takes 2 players as parameters and add one point to the winner.
     *
     * @param player1 first player
     * @param player2 second player
     */
    public static void addPointToWinner(HandPlayer player1, HandPlayer player2) {

        int index1 = options.indexOf(player1.getOption().toString());
        int index2 = options.indexOf(player2.getOption().toString());

        if ((index1 == 0 && index2 == 1) || (index1 == 1 && index2 == 2) || (index1 == 2 && index2 == 0)) {
            player1.addPoint();
        } else if (index1 != index2) {
            player2.addPoint();
        }
    }
}
