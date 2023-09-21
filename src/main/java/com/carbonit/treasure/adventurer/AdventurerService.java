package com.carbonit.treasure.adventurer;

import com.carbonit.treasure.map.*;

public class AdventurerService {
    /**
     * Move the adventurer one square forward if it is possible to do so.
     *
     * @param map The map on which the adventurer is moving.
     */
    public void moveAdventurer(Map map, Adventurer adventurer) {
        int newX = adventurer.getX();
        int newY = adventurer.getY();
        switch (adventurer.getOrientation()) {
            case N -> newY--;
            case S -> newY++;
            case E -> newX++;
            case O -> newX--;
        }
        if (isValidPosition(map, newX, newY)) {
            adventurer.setX(newX);
            adventurer.setY(newY);

            Box boxActuelle = map.getCase(adventurer.getX(), adventurer.getY());
            if (boxActuelle instanceof Treasure treasure) {
                if (treasure.getTreasureNumber() > 0) {
                    treasure.collectTreasure();
                    int collectedTreasures = adventurer.getCollectedTreasures();
                    adventurer.setCollectedTreasures(collectedTreasures + 1);
                }
            }
        }
    }


    /**
     * Check if the new position (x, y) is valid on the given map and not blocked by a mountain.
     *
     * @param map The map to check.
     * @param x   The x-coordinate of the new position.
     * @param y   The y-coordinate of the new position.
     * @return True if the position is valid, false otherwise.
     */
    private boolean isValidPosition(Map map, int x, int y) {
        if (x >= 0 && x < map.getWidth() && y >= 0 && y < map.getHeight()) {
            Box boxActuelle = map.getCase(x, y);
            return !(boxActuelle instanceof Mountain);
        }
        return false;
    }

    /**
     * Turn the adventurer to the right based on their current orientation.
     *
     * @param adventurer The adventurer to turn.
     */
    public void turnRight(Adventurer adventurer) {
        switch (adventurer.getOrientation()) {
            case N -> adventurer.setOrientation(Orientation.E);
            case E -> adventurer.setOrientation(Orientation.S);
            case S -> adventurer.setOrientation(Orientation.O);
            case O -> adventurer.setOrientation(Orientation.N);
        }
        ;
    }

    /**
     * Turn the adventurer to the left based on their current orientation.
     *
     * @param adventurer The adventurer to turn.
     */
    public void turnLeft(Adventurer adventurer) {
        switch (adventurer.getOrientation()) {
            case N -> adventurer.setOrientation(Orientation.O);
            case S -> adventurer.setOrientation(Orientation.E);
            case E -> adventurer.setOrientation(Orientation.N);
            case O -> adventurer.setOrientation(Orientation.S);
        }
        ;
    }
}
