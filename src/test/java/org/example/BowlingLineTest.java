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

    @Test
    public void checkSingleScoringRolls() {

        BowlingLine bowler = new BowlingLine (BOWLER_NAME);
        bowler.addStandardFrame (1, 2);

        assertEquals (3, bowler.sum());
    }

    @Test
    public void checkTemScoringRolls() {
        int i;

        BowlingLine bowler = new BowlingLine (BOWLER_NAME);
        for (i = 0; i < 10; i++) {
            bowler.addStandardFrame(1, 2);
        }

        assertEquals (30, bowler.sum());
    }


    @Test
    public void checkTemScoringRollsOf5() {
        int i;

        BowlingLine bowler = new BowlingLine (BOWLER_NAME);
        for (i = 0; i < 10; i++) {
            bowler.addStandardFrame(3, 2);
        }

        assertEquals (50, bowler.sum());
    }

    @Test
    public void checkTemScoringRollsOf9() {
        int i;

        BowlingLine bowler = new BowlingLine (BOWLER_NAME);
        for (i = 0; i < 10; i++) {
            bowler.addStandardFrame(9, 0);
        }

        assertEquals (90, bowler.sum());
    }



}
