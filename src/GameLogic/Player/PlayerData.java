package GameLogic.Player;

import GameLogic.Components.Cards.Card;

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
    protected final int playerID;

    public PlayerData(int playerID,List<Card> playerDeck) {
        this.playerDeck = playerDeck;
        playerHand = new ArrayList<>();
        elixir = 0;
        this.playerID = playerID;
    }
}
