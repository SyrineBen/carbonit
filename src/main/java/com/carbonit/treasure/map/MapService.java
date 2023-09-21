package com.carbonit.treasure.map;

import com.carbonit.treasure.adventurer.Adventurer;

import java.util.List;

public class MapService {
    /**
     * This method initializes the map based on the input file data.
     *
     * @param lines The data lines from the input file.
     * @return The initialized map.
     */
    public Map initMap(List<String> lines) throws IllegalArgumentException {
        Map map = null;

        for (String line : lines) {
            String[] words = line.split(" - ");
            if (words.length > 0) {
                String type = words[0];

                switch (type) {
                    case "C" -> {
                        if (words.length < 3) {
                            throw new IllegalArgumentException("Invalid format for map creation.");
                        }
                        int width = Integer.parseInt(words[1]);
                        int height = Integer.parseInt(words[2]);
                        map = new Map(width, height);
                    }
                    case "M" -> {
                        if (words.length < 3) {
                            throw new IllegalArgumentException("Invalid format for map creation.");
                        }
                        int xMountain = Integer.parseInt(words[1]);
                        int yMountain = Integer.parseInt(words[2]);
                        if (map != null) {
                            map.addMountain(xMountain, yMountain);
                        }

                    }
                    case "T" -> {
                        if (words.length < 4) {
                            throw new IllegalArgumentException("Invalid format for map creation.");
                        }
                        int treasureX = Integer.parseInt(words[1]);
                        int treasureY = Integer.parseInt(words[2]);
                        int TreasureNumber = Integer.parseInt(words[3]);
                        if (map != null) {
                            map.addTreasure(treasureX, treasureY, TreasureNumber);
                        }
                    }
                    case "A" -> {
                        if (words.length < 6) {
                            throw new IllegalArgumentException("Invalid format for map creation.");
                        }
                        String adventurerName = words[1];
                        int adventurerX = Integer.parseInt(words[2]);
                        int adventurerY = Integer.parseInt(words[3]);
                        Orientation orientation = Orientation.valueOf(words[4]);
                        String movements = words[5];
                        Adventurer adventurer = new Adventurer(adventurerName, adventurerX, adventurerY, orientation, movements);
                        if (map != null) {
                            map.addAdventurer(adventurer);
                        }
                    }
                    default -> {
                    }
                }
            }
        }
        return map;
    }
}
