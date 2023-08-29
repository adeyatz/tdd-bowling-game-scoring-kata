package org.example;

import java.util.ArrayList;

public class BowlingLine {
    private String bowler;
    private ArrayList<Integer> pinsKnockedDown;
    private ArrayList<Frame> frames;

    public BowlingLine(String bowler) {
        this.bowler = bowler;
        pinsKnockedDown = new ArrayList<Integer>();
        frames = new ArrayList<Frame>();
    }

    public String getBowlerName() {
        return bowler;
    }

    public void addStandardFrame(int firstRoll, int secondRoll) {
        frames.add(new StandardFrame (pinsKnockedDown, firstRoll, secondRoll));
    }

    public int sum() {
        int total=0;

        for (Frame frame : frames) {
            total += frame.sum();
        }
        return total;
    }

    public void addSpareFrame(int firstRoll) {
        pinsKnockedDown.add(firstRoll);
        pinsKnockedDown.add(10 - firstRoll);
    }
}
