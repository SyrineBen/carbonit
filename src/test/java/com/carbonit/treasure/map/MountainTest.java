package com.carbonit.treasure.map;

import static org.junit.Assert.*;

import org.junit.Test;

public class MountainTest {

    @Test
    public void testEstTraversable() {
        Mountain mountain = new Mountain(1, 1);
        assertFalse(mountain.isReachable());
    }

    @Test
    public void testToString() {
        Mountain mountain = new Mountain(2, 2);
        assertEquals("M   ", mountain.toString());
    }
}
