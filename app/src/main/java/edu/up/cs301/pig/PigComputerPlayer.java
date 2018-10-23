package edu.up.cs301.pig;

import edu.up.cs301.game.Game;
import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.actionMsg.MyNameIsAction;
import edu.up.cs301.game.infoMsg.BindGameInfo;
import edu.up.cs301.game.infoMsg.GameInfo;
import edu.up.cs301.game.infoMsg.GameState;
import edu.up.cs301.game.infoMsg.NotYourTurnInfo;
import edu.up.cs301.game.util.Tickable;

/**
 * An AI for Pig
 *
 * @author Andrew M. Nuxoll
 * @version August 2015
 */
public class PigComputerPlayer extends GameComputerPlayer {

    /**
     * ctor does nothing extra
     */
    public PigComputerPlayer(String name) {
        super(name);
    }

    /**
     * callback method--game's state has changed
     *
     * @param info
     * 		the information (presumably containing the game's state)
     */
    @Override
    protected void receiveInfo(GameInfo info) {
        PigGameState state;
        GameAction gameAction;

        if(info instanceof NotYourTurnInfo){
            return;
        }

        if(info instanceof PigGameState){
            state = (PigGameState) info;
            double rand = Math.random();

            if(rand < .5){
                gameAction = new PigHoldAction(this);
                if(game instanceof PigLocalGame){
                    sleep(2000);
                    game.sendAction(gameAction);
                }

            } else {
                gameAction = new PigRollAction(this);
                if(game instanceof PigLocalGame){
                    sleep(1000);
                    game.sendAction(gameAction);
                }
            }
        }
    }//receiveInfo
}
