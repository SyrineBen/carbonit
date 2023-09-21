package com.carbonit.treasure.map;


import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PlainTest {

    @Test
    public void testEstTraversable() {
        Plain plain = new Plain(0, 0);
        assertTrue(plain.isReachable());
    }
}

