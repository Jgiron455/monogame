package com.company;

import java.util.Random;

public class Dice {

    public int rollDice(int sides) {
        Random rand = new Random();
        int min = 1;
        int max = sides;
        return rand.nextInt((max - min) + 1) + min;
    }

}
