package GameLogic.Player;

import GameLogic.Board.GameBoard;
import GameLogic.Board.Board;
import GameLogic.Components.Cards.Card;
import GameLogic.Components.Pieces.Piece;
import UserInterface.OutputEvent;
import UserInterface.OutputEventType;
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

    //TODO: delete this comment

    Player(int playerID, List<Card> playerDeck, PlayerIO playerIO) {
        this.playerIO = playerIO;
        init(playerID, playerDeck);
        this.board = GameBoard.getInstance();
    }
    public void gainElixir(int amt) {
        this.data.elixir += amt;
    }
    //May be helpful to define code for this one in util
    public void drawCards() {

        while (data.playerHand.size() < Constants.HAND_SIZE && !data.playerDeck.isEmpty()) {
            data.playerHand.add(data.playerDeck.get(0));
            data.playerDeck.remove(0);
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
                equipAndOutputEvent((PlayerIO.CardAction) action);
            }
            action = playerIO.getAction();
        }
        int returnVal = 1;
        if (action.type == 1) {
            // Handle Piece action, end of turn
            if (action instanceof PlayerIO.PieceAction) {
                PlayerIO.PieceAction pieceAction =  (PlayerIO.PieceAction) action;
                switch (pieceAction.actionType) {
                    //TODO: method for playerIO output events
                    case MOVE -> moveAndOutputEvent(pieceAction);
                    case ATTACK -> returnVal = attackAndOutputEvent(pieceAction);
                }
            } else {
                System.out.println("What are you doing");
            }
        } else {
            System.out.println("HAHA, Val you were wrong, we did something terrible");
        }
        return returnVal;
    }

    /**
     *
     * @param action
     * @return
     * 0 - successful
     * 1 - piece in combat
     * 2 - piece over capacity
     * 3 - unexpected error
     */
    private int handleEquipment(PlayerIO.CardAction action) {
        //Invalid idx
        if (action.idx < 0 || action.idx > data.playerHand.size() - 1) {
            return 3;
        }

        //Invalid coordinate
        boolean rowOut = action.target.row() < 0 || action.target.row() > board.getDimensions().row() - 1;
        boolean colOut = action.target.col() < 0 || action.target.col() > board.getDimensions().col() - 1;
        if (rowOut || colOut) return 3;

        //Identify card and coordinate
        Card card = data.playerHand.get(action.idx);
        Piece piece = board.getPiece(action.target);

        //Return values match
        return piece.equipWeapon(card);
    }

    /**
     * Handles a card action and outputs the result to the playerIO
     * @param action the action to handle
     */
    private void equipAndOutputEvent(PlayerIO.CardAction action) {
        OutputEvent e;
        switch(handleEquipment(action)) {
            case 0 -> {
                e = new OutputEvent(OutputEventType.CardSuccess);
            }
            case 1 -> {
                e = new OutputEvent(OutputEventType.CardFailCombat);
            }
            case 2 -> {
                e = new OutputEvent(OutputEventType.CardFailCapacity);
            }
            case 3 -> {
                e = new OutputEvent(OutputEventType.CardFailInvalidIndex);
            }
            default -> {
                e = new OutputEvent(OutputEventType.CardFailUnknownError);
            }
        }
        playerIO.notifyEvent(e);
    }

    private int attackAndOutputEvent(PlayerIO.PieceAction attack) {
        // TODO safety precautions
        // TODO output event
        return board.attack(attack.source, attack.destination);
    }

    private int moveAndOutputEvent(PlayerIO.PieceAction movement) {
        // TODO output event
        return board.movePiece(movement.source, movement.destination);
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
