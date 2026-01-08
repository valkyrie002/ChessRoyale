package GameLogic;

import GameLogic.Player.Player;
import Util.Constants;

/**
 * Class for player turn methods
 */
public class PlayerTurn {

    public static int playerTurn(Player player, int phase) {
        resourceGain(player,phase);
        return takeTurn(player,phase);
    }

    /**
     * Part 1 of a player turn
     * Method for resource gain
     * @param player the player to gain resources
     * @param phase the phase of the game
     */
    public static void resourceGain(Player player, int phase) {
        switch (phase) {
            case 1 -> {
                player.gainElixir(1);
                if (player.handSize() < Constants.HAND_SIZE){
                    player.drawCard(1);
                }
            }
            case 2 -> {
                player.gainElixir(2);
                player.drawCard(1);
            }
        }
    }

    /**
     * Part two of a player's turn, allocation of resources
     * -> await input
     * @param player
     * @param phase
     */
    public static int takeTurn(Player player, int phase){
        return player.takeTurn();
    }
}
