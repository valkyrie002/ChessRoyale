package GameLogic.Components;

import GameLogic.Player.PlayerData;

/**
 * A game player
 */
public interface Player {
    public void gainElixir(int amt);

    //May be helpful to define code for this one in util
    public void drawCard(int amt);
    public void playCards(int limit);
    public void movePiece();
    //Some way to designate the result of the attack?
    public int attack();
    public String winText();
    //Call this in constructor
    public void initDeck();
    public PlayerData getData();


}
