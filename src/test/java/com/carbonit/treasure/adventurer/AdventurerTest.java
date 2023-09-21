package com.carbonit.treasure.adventurer;

import com.carbonit.treasure.map.Map;
import com.carbonit.treasure.map.Orientation;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AdventurerTest {

    private Map map;
    private AdventurerService adventurerService;

    @Before
    public void setUp() {
        int mapWidth = 5;
        int mapHeight = 5;
        map = new Map(mapWidth, mapHeight);
        adventurerService = new AdventurerService();
    }

    @Test
    public void testSimulerMouvements() {
        Adventurer adventurer = new Adventurer("Testadventurer", 1, 1, Orientation.N, "AADADA");
        map.addAdventurer(adventurer);
        map.play();
        assertEquals(2, adventurer.getX());
        assertEquals(1, adventurer.getY());
        assertEquals(0, adventurer.getCollectedTreasures());
    }

    @Test
    public void testTournerADroite() {
        Adventurer adventurer = new Adventurer("Testadventurer", 1, 1, Orientation.N, "");
        adventurerService.turnRight(adventurer);
        adventurerService.turnRight(adventurer);
        assertEquals(Orientation.S, adventurer.getOrientation());
    }

    @Test
    public void testTournerAGauche() {
        Adventurer adventurer = new Adventurer("Testadventurer", 1, 1, Orientation.N, "");
        adventurerService.turnLeft(adventurer);
        adventurerService.turnLeft(adventurer);
        assertEquals(Orientation.S, adventurer.getOrientation());
    }
}
