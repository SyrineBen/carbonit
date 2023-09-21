package com.carbonit.treasure.map;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MapServiceTest {

    private MapService mapService;

    @Before
    public void setUp() {
        mapService = new MapService();
    }

    @Test
    public void testInitMapValidInput() {
        List<String> inputLines = List.of("C - 5 - 5", "M - 1 - 1", "A - Test - 1 - 1 - N - A");
        Map map = mapService.initMap(inputLines);
        assertNotNull(map);
        assertTrue(map.getCase(1,1) instanceof Mountain);
        assertEquals(5, map.getHeight());
        assertNotNull(map.getAdventurers().get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInitMapInvalidMapInput() {
        List<String> inputLines = List.of("C - 1");
        mapService.initMap(inputLines);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInitMapInvalidTresorInput() {
        List<String> inputLines = List.of("T - 1");
        mapService.initMap(inputLines);
    }
}

