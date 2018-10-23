package edu.up.cs301.pig;

import android.util.Log;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.actionMsg.MyNameIsAction;

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {
    private PigGameState state;

    /**
     * This ctor creates a new game state
     */
    public PigLocalGame() {
        state = new PigGameState();
    }

    /**
     * This ctor creates a new game state
     * acts as copy
     */
    public PigLocalGame(PigGameState pgs) {
        state = pgs;
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {
        if(playerIdx == state.getPlayerTurn()){
            return true;
        }
        return false;
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {
       int playerID = state.getPlayerTurn();

       /*
        if(action instanceof MyNameIsAction){
            MyNameIsAction myNameIsAction = (MyNameIsAction) action;

            if(playerID == 0){
                state.setPlayer0Name("Player 0");
            } else if (playerID == 1){
                state.setPlayer1Name("Player 1");
            } else {
                Log.i("PigLocalGame", "Error in handling MyNameIsAction in makeMove()");
            }
        }*/

        String name = "name";
        if(state.getPlayerTurn()== 0){
            name = "Player 0";
        }
        else if(state.getPlayerTurn() ==1){
            name = "Player 1";
        }

        if(action instanceof PigHoldAction){
            if(playerID == 0) {
                state.setPlayer0Score(state.getPlayer0Score()+ state.getRunningTotal());
            }
            else {
                state.setPlayer1Score(state.getPlayer1Score()+ state.getRunningTotal());
            }
            state.setMessage(name + " added " +state.getRunningTotal() + " points");
            state.setRunningTotal(0);
            //TODO: check if there is more than 1 player?
            switchTurn();
            return true;
        }

        else if(action instanceof PigRollAction){
            int value = (int)(Math.random()*6) + 1;

            if(value != 1) {
                state.setRunningTotal(state.getRunningTotal() + value);
            }
            else {
                state.setRunningTotal(0);
                state.setMessage("Oh No " + name + " rolled a 1");
                //TODO: check if there is more than 1 player?
                switchTurn();
            }
            state.setDiceValue(value);
            return true;
        }
        return false;
    }//makeMove

    protected void switchTurn(){

        if(state.getPlayerTurn() == 1){
            state.setPlayerTurn(0);
        }
        else{
            state.setPlayerTurn(1);
        }
    }
    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        PigGameState pgs = new PigGameState(state);
        p.sendInfo(pgs);
    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {
        if(state.getPlayer1Score()>=50){
            return "Congratulations player 1! You won with " + state.getPlayer1Score() + "points.";
        }
        else if(state.getPlayer0Score()>=50){
            return "Congratulations player 0! You won with " + state.getPlayer0Score() + "points.";
        }
        return null;
    }

}// class PigLocalGame

//An extra comment to demonstrate commitments
