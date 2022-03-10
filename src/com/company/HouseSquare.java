package com.company;

import java.util.Optional;

public class HouseSquare extends Square {

    public HouseSquare(String name, int price, int chargeCost) {
        super(name, price, chargeCost);
    }

    @Override
    public void buy(Player player) {
            if(!isOwned){
                player.setMoney(player.getMoney() - this.price);
                player.getPropertiesOwned().add(this.name);
                this.isOwned = true;
            }
    }

    @Override
    public void sell(Player player) {
        // todo write your own logic.... this is to advance
        // todo https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html
        Optional<String> found = player.getPropertiesOwned()
                .stream()
                .parallel()
                .filter(property -> property.equalsIgnoreCase(this.name)).findFirst();

        if(isOwned && found.isPresent()) {
            player.removeProperty(player.getPropertiesOwned().indexOf(found.get()));
            player.setMoney(this.price);
            this.isOwned = false;
        }

    }

    @Override
    public void chargePlayer(Player player) {
        if(!isOwner(player)){
            player.setMoney(player.getMoney() - this.chargeCost);
        }
    }

    @Override
    public boolean isOwner(Player player) {
        Optional<String> found = player.getPropertiesOwned()
                .stream()
                .parallel()
                .filter(property -> property.equalsIgnoreCase(this.name)).findFirst();
        return isOwned && found.isPresent();

    }


}
