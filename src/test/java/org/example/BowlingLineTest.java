package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BowlingLineTest {

    static final String BOWLER_NAME = "John Test";
    @Test
    public void checkBowlingLineConstructor () {
        BowlingLine bowler = new BowlingLine (BOWLER_NAME);
        assertNotNull (bowler);
        assertEquals(BOWLER_NAME, bowler.getBowlerName());
    }

    @Test
    public void checkSingleGutterRolls() {

        BowlingLine bowler = new BowlingLine (BOWLER_NAME);
        bowler.addStandardFrame (0, 0);

        assertEquals (0, bowler.sum());
    }
}
