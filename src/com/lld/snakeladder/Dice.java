package com.lld.snakeladder;

import java.util.Objects;

public class Dice {

    private int numberOfDice;

    public Dice(int numberOfDice) {
        this.numberOfDice = numberOfDice;
    }

    int rollDice(){
       //  Random r = new Random();
       //  r.ints(1,6*numberOfDice).findFirst().getAsInt();
        return ((int) (Math.random()*(6*numberOfDice - 1*numberOfDice))) + numberOfDice;
    }

    public int getNumberOfDice() {
        return numberOfDice;
    }

    public void setNumberOfDice(int numberOfDice) {
        this.numberOfDice = numberOfDice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dice dice = (Dice) o;
        return numberOfDice == dice.numberOfDice;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfDice);
    }
}
