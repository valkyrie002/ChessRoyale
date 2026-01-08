package UserInterface;

import Util.ActionType;
import Util.Coordinate;

public interface PlayerIO {
    public Action getAction();
    public void notifyEvent(OutputEvent m);

    public class Action {
        public final int type;
        public Action(int type){this.type = type;}
    }

    public class CardAction extends Action {
        public final int idx;
        public final Coordinate target;
        public CardAction(int idx, Coordinate target) {
            super(1);
            this.idx = idx;
            this.target = target;
        }
    }

    public class PieceAction extends Action {
        public final ActionType actionType;
        public final Coordinate source;
        public final Coordinate destination;
        public PieceAction(ActionType actionType, Coordinate source,
                           Coordinate destination) {
            super(2);
            this.actionType = actionType;
            this.source = source;
            this.destination = destination;
        }

    }
}
