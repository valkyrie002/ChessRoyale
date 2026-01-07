package GameLogic.Player;

import GameLogic.Components.Card;
import GameLogic.Components.Player;
import Util.Constants;

import java.util.List;

public class ConsoleHuman implements Player {
    PlayerData data;

    ConsoleHuman(int playerID, List<Card> playerDeck) {
        init(playerID, playerDeck);
    }

    @Override
    public void gainElixir(int amt) {
        this.data.elixir += amt;
    }

    @Override
    public void drawCard(int amt) {
        for (int i = 0; i < amt; i++) {
            if (!data.playerDeck.isEmpty()) {
                data.playerHand.add(data.playerDeck.get(0));
                data.playerDeck.remove(0);
            }
        }
        if (data.playerHand.size() > Constants.HAND_SIZE); //definitely do something here
        if (data.playerDeck.isEmpty()); //Should we do something here?
    }

    @Override
    public void playCards(int limit) {

    }

    @Override
    public void movePiece() {

    }

    @Override
    public int attack() {
        return 0;
    }

    @Override
    public String winText() {
        return null;
    }

    @Override
    public void init(int playerID, List<Card> playerDeck) {
        data = new PlayerData(playerID, playerDeck);
    }

    @Override
    public PlayerData getData() {
        return data;
    }
}
