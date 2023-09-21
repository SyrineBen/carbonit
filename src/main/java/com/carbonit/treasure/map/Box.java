package com.carbonit.treasure.map;

public abstract class Box {

    protected int x;
    protected int y;

    public Box(int x, int y) {
        this.x = x;
        this.y = y;
    }
    abstract boolean isReachable();

    @Override
    public String toString() {
        return "";
    }

}
