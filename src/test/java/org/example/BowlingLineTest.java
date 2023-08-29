package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BowlingLineTest {

    static final String BOWLER_NAME = "John Test";
    private BowlingLine bowler;

    @BeforeEach
    public void init() {
        bowler = new BowlingLine(BOWLER_NAME);          // Arrange
    }


    @Test
    public void checkBowlingLineConstructor () {
        assertNotNull (bowler);
        assertEquals(BOWLER_NAME, bowler.getBowlerName());
    }

    @Test
    public void checkSingleGutterRolls() {

        bowler.addStandardFrame (0, 0);

        assertEquals (0, bowler.sum());
    }

    @Test
    public void checkSingleScoringRolls() {

        bowler.addStandardFrame (1, 2);

        assertEquals (3, bowler.sum());
    }

    @Test
    public void checkTenScoringRolls() {

        for (int i = 0; i < 10; i++) {
            bowler.addStandardFrame(1, 2);
        }

        assertEquals (30, bowler.sum());
    }


    @Test
    public void checkTenScoringRollsOf5() {

        for (int i = 0; i < 10; i++) {
            bowler.addStandardFrame(3, 2);
        }

        assertEquals (50, bowler.sum());
    }

    @Test
    public void checkTenScoringRollsOf9() {

        for (int i = 0; i < 10; i++) {
            bowler.addStandardFrame(9, 0);
        }

        assertEquals (90, bowler.sum());
    }

    @Test
    public void checkTenGutterRolls() {

        for (int i = 0; i < 10; i++) {
            bowler.addStandardFrame(0, 0);
        }

        assertEquals (0, bowler.sum());
    }

    // First test for Spare frame
    @Test
    public void checkSingleSpareWithGutterRoll() {

        bowler.addSpareFrame(5);
        bowler.addStandardFrame(0,0);

        assertEquals (10, bowler.sum());
    }

    @Test
    public void checkSingleSpareWithStandardRoll() {

        bowler.addSpareFrame(5);
        bowler.addStandardFrame(1,2);

        assertEquals (14, bowler.sum());
    }

    @Test
    public void checkSingleSpareWith9GutterRolls() {

        bowler.addSpareFrame(5);
        for (int i = 1; i < 10; i++) {
            bowler.addStandardFrame(0, 0);
        }

        assertEquals(10, bowler.sum());
    }

    @Test
    public void checkSingleSpareWithScoreThenGutterRolls() {

        bowler.addSpareFrame(5);
        bowler.addStandardFrame(1,0);
        for (int i = 2; i < 10; i++) {
            bowler.addStandardFrame(0, 0);
        }

        assertEquals(12, bowler.sum());
    }

    @Test
    public void checkSingleSpareNineOneWithScoreThenGutterRolls() {

        bowler.addSpareFrame(9);
        bowler.addStandardFrame(1,0);
        for (int i = 2; i < 10; i++) {
            bowler.addStandardFrame(0, 0);
        }

        assertEquals(12, bowler.sum());
    }

    @Test
    public void checkSingleSpareZeroTenWithScoreThenGutterRolls() {

        bowler.addSpareFrame(0);
        bowler.addStandardFrame(1,0);
        for (int i = 2; i < 10; i++) {
            bowler.addStandardFrame(0, 0);
        }

        assertEquals(12, bowler.sum());
    }

    // First Test for StrikeFrame
    @Test
    public void checkSingleStrikeWithGutterRoll() {

        bowler.addStrikeFrame();
        bowler.addStandardFrame(0,0);

        assertEquals (10, bowler.sum());
    }

    @Test
    public void checkSingleStrikeWithStandardOneNilThenGutterRoll() {

        bowler.addStrikeFrame();
        bowler.addStandardFrame(1,0);

        for (int i = 2; i < 10; i++) {
            bowler.addStandardFrame(0, 0);
        }

        assertEquals (12, bowler.sum());
    }

    @Test
    public void checkSingleStrikeWithStandardOneTwoThenGutterRoll() {

        bowler.addStrikeFrame();
        bowler.addStandardFrame(1,2);

        for (int i = 2; i < 10; i++) {
            bowler.addStandardFrame(0, 0);
        }

        assertEquals (16, bowler.sum());
    }

    @Test
    public void checkSingleStrikeWithSpareThenGutterRoll() {

        bowler.addStrikeFrame();
        bowler.addSpareFrame(5);

        for (int i = 2; i < 10; i++) {
            bowler.addStandardFrame(0, 0);
        }

        assertEquals (30, bowler.sum());
    }


    @Test
    public void checkStandardOneTwoSingleStrikeStandardThreeFourThenGutterRoll() {

        bowler.addStandardFrame(1,2);
        bowler.addStrikeFrame();
        bowler.addStandardFrame(3,4);

        for (int i = 3; i < 10; i++) {
            bowler.addStandardFrame(0, 0);
        }

        assertEquals (27, bowler.sum());
    }


    @Test
    public void checkThreeStrikeThenGutterRoll() {

        bowler.addStrikeFrame();
        bowler.addStrikeFrame();
        bowler.addStrikeFrame();

        for (int i = 3; i < 10; i++) {
            bowler.addStandardFrame(0, 0);
        }

        assertEquals (60, bowler.sum());
    }



    // First test for Bonus
    @Test
    public void checkSpareBonusBall() {

        for (int i = 0; i < 9; i++) {
            bowler.addStandardFrame(0, 0);
        }
        bowler.addSpareFrame(5);
        bowler.addBonus (8);
        assertEquals (18, bowler.sum());
    }

    @Test
    public void checkStrikeBonusBalls() {

        for (int i = 0; i < 9; i++) {
            bowler.addStandardFrame(0, 0);
        }
        bowler.addStrikeFrame();
        bowler.addBonus (8);
        bowler.addBonus(3);
        assertEquals (21, bowler.sum());
    }


    @Test
    public void checkStrikeBonus10Bonus5() {

        for (int i = 0; i < 9; i++) {
            bowler.addStandardFrame(0, 0);
        }
        bowler.addStrikeFrame();
        bowler.addBonus (10);
        bowler.addBonus(5);
        assertEquals (25, bowler.sum());
    }


    @Test
    public void checkStrikeBonus10Bonus10() {

        for (int i = 0; i < 9; i++) {
            bowler.addStandardFrame(0, 0);
        }
        bowler.addStrikeFrame();
        bowler.addBonus (10);
        bowler.addBonus(10);
        assertEquals (30, bowler.sum());
    }

    // Additional tests

    @Test
    public void checkAllSparesBonus5() {

        for (int i = 0; i < 10; i++) {
            bowler.addSpareFrame(8);
        }
        bowler.addBonus (5);
        assertEquals (177, bowler.sum());
    }


    @Test
    public void checkMaximumScore() {

        for (int i = 0; i < 10; i++) {
            bowler.addStrikeFrame();
        }
        bowler.addBonus (10);
        bowler.addBonus (10);
        assertEquals (300, bowler.sum());
    }

    @Test
    public void checkAlternateStrikeSpare() {

        for (int i = 0; i < 5; i++) {
            bowler.addStrikeFrame();
            bowler.addSpareFrame(6);
        }
        bowler.addBonus (10);
        assertEquals (200, bowler.sum());
    }

}
