package com.carbonit.treasure.map;

import com.carbonit.treasure.adventurer.Adventurer;
import com.carbonit.treasure.adventurer.AdventurerService;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private final int width;
    private final int height;
    private final Box[][] grid;

    private final List<Adventurer> adventurers;

    private final AdventurerService adventurerService;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        this.grid = new Box[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                grid[x][y] = new Plain(x, y);
            }
        }
        adventurers = new ArrayList<>();
        this.adventurerService = new AdventurerService();
    }

    public void addMountain(int x, int y) {
        grid[x][y] = new Mountain(x, y);
    }

    public void addAdventurer(Adventurer Adventurer) {
        adventurers.add(Adventurer);
    }

    public void addTreasure(int x, int y, int treasureNumber) {
        grid[x][y] = new Treasure(x, y, treasureNumber);
    }

    public Box getCase(int x, int y) {
        return grid[x][y];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<Adventurer> getAdventurers() {
        return adventurers;
    }

    public void play() {
        List<Adventurer> AdventurersTries = new ArrayList<>(this.getAdventurers());

        int maxSequenceLength = AdventurersTries.stream()
                .mapToInt(Adventurer -> Adventurer.getMovements().length())
                .max().orElse(0);

        for (int i = 0; i < maxSequenceLength; i++) {
            for (Adventurer adventurer : AdventurersTries) {
                String sequence = adventurer.getMovements();
                if (i < sequence.length()) {
                    char mouvement = sequence.charAt(i);
                    switch (mouvement) {
                        case 'A' -> adventurerService.moveAdventurer(this, adventurer);
                        case 'D' -> adventurerService.turnRight(adventurer);
                        case 'G' -> adventurerService.turnLeft(adventurer);
                    }
                }
            }
        }
    }


    @Override
    public String toString() {
        StringBuilder map = new StringBuilder();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                boolean AdventurerPresent = false;
                for (Adventurer Adventurer : adventurers) {
                    if (Adventurer.getX() == x && Adventurer.getY() == y) {
                        map.append(Adventurer);
                        AdventurerPresent = true;
                        break;
                    }
                }
                if (!AdventurerPresent) {
                    map.append(grid[x][y]);
                }
                map.append(" ");
            }
            map.append("\n");
        }
        return map.toString();
    }
}
