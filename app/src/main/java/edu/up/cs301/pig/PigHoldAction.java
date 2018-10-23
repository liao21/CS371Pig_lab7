package edu.up.cs301.pig;

import edu.up.cs301.game.actionMsg.GameAction;

public class PigHoldAction extends GameAction {

    public PigHoldAction(PigHumanPlayer php){
        super(php);
    }

    public PigHoldAction(PigComputerPlayer pcp){
        super(pcp);
    }
}
