package edu.up.cs301.pig;

import edu.up.cs301.game.infoMsg.GameState;

public class PigGameState extends GameState{
    private int playerTurn;
    private int player0Score;
    private int player1Score;
    private int runningTotal;
    private int diceValue;
    private String player0Name;
    private String player1Name;
    private PigGameState state;
    private String message;

    public PigGameState(){
         playerTurn = 0;
         player0Score = 0;
         player1Score = 0;
         runningTotal = 0;
         diceValue = 0;
         player0Name = "";
         player1Name = "";
         message = "";
    }

    public PigGameState(PigGameState pgs){
        this.setPlayerTurn(pgs.getPlayerTurn());
        this.setPlayer0Score(pgs.getPlayer0Score());
        this.setPlayer1Score(pgs.getPlayer1Score());
        this.setRunningTotal(pgs.getRunningTotal());
        this.setDiceValue(pgs.getDiceValue());
        this.setPlayer0Name(pgs.getPlayer0Name());
        this.setPlayer1Name(pgs.getPlayer1Name());
        this.setMessage(pgs.getMessage());

    }

    public int getPlayerTurn() {
        return playerTurn;
    }

    public int getPlayer0Score() {
        return player0Score;
    }

    public int getPlayer1Score() {
        return player1Score;
    }

    public int getRunningTotal() {
        return runningTotal;
    }

    public int getDiceValue() {
        return diceValue;
    }

    public String getPlayer0Name() { return player0Name; }

    public String getPlayer1Name() { return player1Name; }

    public String getMessage() {
        return message;
    }

    public void setPlayerTurn(int playerTurn) {
        this.playerTurn = playerTurn;
    }

    public void setPlayer0Score(int player0Score) {

        this.player0Score = player0Score;
    }

    public void setPlayer1Score(int player1Score) {

        this.player1Score = player1Score;
    }

    public void setRunningTotal(int runningTotal) {
        this.runningTotal = runningTotal;
    }

    public void setDiceValue(int diceValue) {
        this.diceValue = diceValue;
    }

    public void setPlayer0Name(String name) { this.player0Name = name; }

    public void setPlayer1Name(String name) { this.player1Name = name; }

    public void setMessage(String message) {
        this.message = message;
    }

    //TODO: determine if I need this method
    public PigGameState getPigGameState() { return state; }

}
