package GameLogic.Player;

import GameLogic.Components.Board;
import GameLogic.Components.Card;
import UserInterface.PlayerIO;
import Util.Constants;

import java.util.List;

/**
 * A game player
 */
public class Player {
    PlayerData data;
    private final PlayerIO playerIO;
    private final Board board;

    Player(int playerID, List<Card> playerDeck, PlayerIO playerIO, Board board) {
        this.playerIO = playerIO;
        init(playerID, playerDeck);
        this.board = board;
    }
    public void gainElixir(int amt) {
        this.data.elixir += amt;
    }
    //May be helpful to define code for this one in util
    public void drawCard(int amt) {
        //TODO: fillHand

        for (int i = 0; i < amt; i++) {
            if (!data.playerDeck.isEmpty()) {
                data.playerHand.add(data.playerDeck.get(0));
                data.playerDeck.remove(0);
            }
        }
        while (data.playerHand.size() > Constants.HAND_SIZE){
            System.out.println("hand over capacity");
            Card cRemoved = data.playerHand.remove(data.playerHand.size() - 1);
            data.playerDeck.add(cRemoved);
        }
        if (data.playerDeck.isEmpty()){
            System.out.println("empty deck, what the heck");
            // TODO: get opponents discraded cards?
        }
    }    //Some way to designate the result of the attack?
//    public String winText();
    //Call this in constructor
    public void init(int playerID, List<Card> playerDeck) {
        data = new PlayerData(playerID, playerDeck);
    }
    public PlayerData getData() {
        return data;
    }
    public int handSize() {
        return data.playerHand.size();
    }

    /**
     *
     * @return game state
     * 1 -> game ongoing
     * 0 -> game over
     */
    public int takeTurn(){
        PlayerIO.Action action = new PlayerIO.Action(-1);
        while(action.type != 2) {
            // Handle Card actions aka weapon equipment
            if (action instanceof PlayerIO.CardAction) {
                handleEquipment((PlayerIO.CardAction) action);
            }
            action = playerIO.getAction();
        }
        int returnVal = 1;
        if (action.type == 1) {
            // Handle Piece action, end of turn
            if (action instanceof PlayerIO.PieceAction) {
                PlayerIO.PieceAction pieceAction =  (PlayerIO.PieceAction) action;
                switch (pieceAction.actionType) {
                    case MOVE -> handleMovement(pieceAction);
                    case ATTACK -> returnVal = handleAttack(pieceAction);
                }
            } else {
                System.out.println("What are you doing");
            }
        } else {
            System.out.println("HAHA, Val you were wrong, we did something terrible");
        }
        return returnVal;
    }

    private void handleEquipment(PlayerIO.CardAction action) {
        // TODO

    }

    private int handleAttack(PlayerIO.PieceAction attack) {
        // TODO safety precautions
        return board.attack(data.playerID, attack.source, attack.destination);
    }

    private void handleMovement(PlayerIO.PieceAction movement) {
        //TODO safety precautions
        board.movePiece(data.playerID, movement.source, movement.destination);
    }

    private void playCards(int limit) {
    }

    private void movePiece() {

    }

    private int attack() {
        return 0;
    }

    static void main() {

    }

}
