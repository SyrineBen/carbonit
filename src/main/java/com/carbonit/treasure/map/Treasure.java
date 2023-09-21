package com.carbonit.treasure.map;

public class Treasure extends Box {

    private int treasureNumber;

    public Treasure(int x, int y, int treasureNumber) {
        super(x, y);
        this.treasureNumber = treasureNumber;
    }

    public int getTreasureNumber() {
        return treasureNumber;
    }


    public void collectTreasure() {
        if (treasureNumber > 0) {
            treasureNumber--;
        }
    }

    @Override
    boolean isReachable() {
        return true;
    }

    @Override
    public String toString() {
        return "T(" + treasureNumber + ")";
    }


}
