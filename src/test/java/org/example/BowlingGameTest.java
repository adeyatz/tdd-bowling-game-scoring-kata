package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class BowlingGameTest {

    static final String BOWLER_NAME = "John Test";
    private BowlingGame bowlingGame;
    @BeforeEach
        public void init() {

        bowlingGame = new BowlingGame(BOWLER_NAME);          // Arrange
    }

    @Test
    void checkBowlingGameConstructor() {
        assertNotNull(bowlingGame);
        assertEquals(BOWLER_NAME, bowlingGame.getBowlerName());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/BowlingScoreTests.csv")
    public void checkInputvsExpectedFromCSVFile (String bowlingScoreLine,int expectedScore) {

        System.out.printf("Input: %s, Expected score: %d\n", bowlingScoreLine, expectedScore);

        assertEquals (expectedScore, bowlingGame.calculateSum(bowlingScoreLine));
    }
}