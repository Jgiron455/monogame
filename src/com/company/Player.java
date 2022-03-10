package com.company;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;

    private int money;

    private int score;

    private int boardPosition;

    private List<String> propertiesOwned;


    public Player(String name, int money) {
        this.name = name;
        this.money = money;
        this.score = 0;
        this.boardPosition = 0;
        this.propertiesOwned = new ArrayList<String>();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getBoardPosition() {
        return boardPosition;
    }

    public void setBoardPosition(int boardPosition) {
        this.boardPosition = boardPosition;
    }

    public List<String> getPropertiesOwned() {
        return propertiesOwned;
    }

    public void setPropertiesOwned(List<String> propertiesOwned) {
        this.propertiesOwned = propertiesOwned;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void removeProperty(int position){
        this.propertiesOwned.remove(position);
    }
}
