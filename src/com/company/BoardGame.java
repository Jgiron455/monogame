package com.company;

import java.util.List;

public class BoardGame {

    public List<Player> playerList;

    public List<Square> board;

    public Dice dice;

    public boolean isGameOver;

    public BoardGame(List<Player> playerList, List<Square> board) {
        this.playerList = playerList;
        this.board = board;
        this.dice = new Dice();
        this.isGameOver = false;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void setGameOver(boolean gameOver) {
        isGameOver = gameOver;
    }
}
