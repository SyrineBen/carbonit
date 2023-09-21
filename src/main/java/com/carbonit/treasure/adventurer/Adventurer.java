package com.carbonit.treasure.adventurer;

import com.carbonit.treasure.map.*;

/**
 * Represents an adventurer exploring the map in search of treasures.
 */
public class Adventurer {

    private String name;
    private String movements;

    private int collectedTreasures;
    private Orientation orientation;
    private int x;
    private int y;

    /**
     * Creates a new adventurer.
     *
     * @param name                  The name of the adventurer.
     * @param x                     The X-coordinate position of the adventurer.
     * @param y                     The Y-coordinate position of the adventurer.
     * @param orientation           The orientation of the adventurer (N, S, E, or O).
     * @param movements             The movements of the adventurer.
     */
    public Adventurer(String name, int x, int y, Orientation orientation, String movements) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.movements = movements;
        this.collectedTreasures = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public int getCollectedTreasures() {
        return collectedTreasures;
    }

    public void setCollectedTreasures(int collectedTreasures) {
        this.collectedTreasures = collectedTreasures;
    }

    public String getMovements() {
        return movements;
    }

    public void setMovements(String movements) {
        this.movements = movements;
    }


    @Override
    public String toString() {
        return "A(" + name + ")  ";
    }
}
