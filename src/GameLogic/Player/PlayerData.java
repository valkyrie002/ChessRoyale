package GameLogic.Player;

import GameLogic.Components.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for holding player data
 * Every player implementation should have this
 */
public class PlayerData {
    protected List<Card> playerDeck;
    protected List<Card> playerHand;
    protected int elixir;
    public PlayerData() {
        playerDeck = new ArrayList<>();
        playerHand = new ArrayList<>();
        elixir = 0;
    }
}
