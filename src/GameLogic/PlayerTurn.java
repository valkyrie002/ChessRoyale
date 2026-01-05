package GameLogic;

import GameLogic.Components.Player;

/**
 * Class for player turn methods
 */
public class PlayerTurn {
    public static int playerTurn(Player player, int phase) {
        resourceGain(player,phase);
        resourceAllocate(player,phase);
        return armyCommand(player,phase);
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
                player.drawCard(1);
            }
            case 2 -> {
                player.gainElixir(2);
                player.drawCard(1);
            }
        }
    }
    public static void resourceAllocate(Player player, int phase){}
    public static int armyCommand(Player player, int phase){
        return 0;
    }

}
