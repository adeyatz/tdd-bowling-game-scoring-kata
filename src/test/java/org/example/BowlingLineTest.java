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
    public void checkTenScoringRolls() {
        int i;

        BowlingLine bowler = new BowlingLine (BOWLER_NAME);
        for (i = 0; i < 10; i++) {
            bowler.addStandardFrame(1, 2);
        }

        assertEquals (30, bowler.sum());
    }


    @Test
    public void checkTenScoringRollsOf5() {
        int i;

        BowlingLine bowler = new BowlingLine (BOWLER_NAME);
        for (i = 0; i < 10; i++) {
            bowler.addStandardFrame(3, 2);
        }

        assertEquals (50, bowler.sum());
    }

    @Test
    public void checkTenScoringRollsOf9() {
        int i;

        BowlingLine bowler = new BowlingLine (BOWLER_NAME);
        for (i = 0; i < 10; i++) {
            bowler.addStandardFrame(9, 0);
        }

        assertEquals (90, bowler.sum());
    }

    @Test
    public void checkTenGutterRolls() {
        int i;

        BowlingLine bowler = new BowlingLine (BOWLER_NAME);
        for (i = 0; i < 10; i++) {
            bowler.addStandardFrame(0, 0);
        }

        assertEquals (0, bowler.sum());
    }

    // First test for Spare frame
    @Test
    public void checkSingleSpareWithGutterRoll() {

        BowlingLine bowler = new BowlingLine (BOWLER_NAME);

        bowler.addSpareFrame(5);
        bowler.addStandardFrame(0,0);

        assertEquals (10, bowler.sum());
    }

    @Test
    public void checkSingleSpareWithStandardRoll() {

        BowlingLine bowler = new BowlingLine (BOWLER_NAME);

        bowler.addSpareFrame(5);
        bowler.addStandardFrame(1,2);

        assertEquals (14, bowler.sum());
    }

    @Test
    public void checkSingleSpareWith9GutterRolls() {

        BowlingLine bowler = new BowlingLine(BOWLER_NAME);

        bowler.addSpareFrame(5);
        for (int i = 1; i < 10; i++) {
            bowler.addStandardFrame(0, 0);
        }

        assertEquals(10, bowler.sum());
    }

    @Test
    public void checkSingleSpareWithScoreThenGutterRolls() {

        BowlingLine bowler = new BowlingLine(BOWLER_NAME);

        bowler.addSpareFrame(5);
        bowler.addStandardFrame(1,0);
        for (int i = 2; i < 10; i++) {
            bowler.addStandardFrame(0, 0);
        }

        assertEquals(12, bowler.sum());
    }

    @Test
    public void checkSingleSpareNineOneWithScoreThenGutterRolls() {

        BowlingLine bowler = new BowlingLine(BOWLER_NAME);

        bowler.addSpareFrame(9);
        bowler.addStandardFrame(1,0);
        for (int i = 2; i < 10; i++) {
            bowler.addStandardFrame(0, 0);
        }

        assertEquals(12, bowler.sum());
    }

    @Test
    public void checkSingleSpareZeroTenWithScoreThenGutterRolls() {

        BowlingLine bowler = new BowlingLine(BOWLER_NAME);

        bowler.addSpareFrame(0);
        bowler.addStandardFrame(1,0);
        for (int i = 2; i < 10; i++) {
            bowler.addStandardFrame(0, 0);
        }

        assertEquals(12, bowler.sum());
    }
}
