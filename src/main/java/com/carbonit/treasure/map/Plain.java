package com.carbonit.treasure.map;

public class Plain extends Box {

    public Plain(int x, int y) {
        super(x, y);
    }

    @Override
    boolean isReachable() {
        return true;
    }

    @Override
    public String toString() {
        return ".   ";
    }
}
