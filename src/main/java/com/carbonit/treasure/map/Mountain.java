package com.carbonit.treasure.map;

public class Mountain extends Box {

    public Mountain(int x, int y) {
        super(x, y);
    }

    @Override
    boolean isReachable() {
        return false;
    }

    @Override
    public String toString() {
        return "M   ";
    }
}
