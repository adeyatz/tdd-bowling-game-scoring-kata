package org.example;

import java.util.ArrayList;

public class BowlingLine {
    private String bowler;
    private ArrayList<Integer> pinsKnockedDown;

    public BowlingLine(String bowler) {
        this.bowler = bowler;
        pinsKnockedDown = new ArrayList<Integer>();

    }

    public String getBowlerName() {
        return bowler;
    }

    public void addStandardFrame(int firstRoll, int secondRoll) {
        pinsKnockedDown.add(firstRoll);
        pinsKnockedDown.add(secondRoll);
    }

    public int sum() {
        int total=0;

        for (Integer pinsDown : pinsKnockedDown) {
            total += pinsDown;
        }
        return total;
    }
}
