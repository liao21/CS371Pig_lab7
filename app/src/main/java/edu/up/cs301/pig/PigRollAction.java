package edu.up.cs301.pig;

import edu.up.cs301.game.actionMsg.GameAction;

public class PigRollAction extends GameAction {

    public PigRollAction(PigHumanPlayer php){
        super(php);
    }

    public PigRollAction(PigComputerPlayer pcp){
        super(pcp);
    }
}
