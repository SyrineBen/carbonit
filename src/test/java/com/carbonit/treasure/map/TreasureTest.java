package com.carbonit.treasure.map;

import org.junit.Test;

import static org.junit.Assert.*;

public class TreasureTest {
    @Test
    public void testEstTraversable() {
        Treasure treasure = new Treasure(1, 1, 2);
        assertTrue(treasure.isReachable());
    }

    @Test
    public void testCollecterTresor() {
        Treasure treasure = new Treasure(2, 2, 3);
        int leftTreasures = treasure.getTreasureNumber();
        treasure.collectTreasure();
        assertEquals(leftTreasures - 1, treasure.getTreasureNumber());
    }

    @Test
    public void testCollecterTousLesTresors() {
        Treasure treasure = new Treasure(3, 3, 2);
        for (int i = 0; i < 2; i++) {
            treasure.collectTreasure();
        }
        assertEquals(0, treasure.getTreasureNumber());
    }
}
