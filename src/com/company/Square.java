package com.company;

public abstract class Square {

    public String name;

    public int price;

    public int chargeCost;

    public boolean isOwned;

    public Square(String name, int price, int chargeCost) {
        this.name = name;
        this.price = price;
        this.chargeCost = chargeCost;
        this.isOwned = false;
    }

    public abstract void buy(Player player);

    public abstract void sell(Player player);

    public abstract void chargePlayer(Player player);

    public abstract  boolean isOwner(Player player);

}
