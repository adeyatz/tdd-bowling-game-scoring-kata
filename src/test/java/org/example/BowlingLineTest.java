package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BowlingLineTest {

    @Test
    public void checkBowlingLineConstructor () {
        String bowlerName = "John Doe";
        BowlingLine bowler = new BowlingLine (bowlerName);
        assertNotNull (bowler);
        assertEquals(bowlerName, bowler.getBowlerName());
    }
}
