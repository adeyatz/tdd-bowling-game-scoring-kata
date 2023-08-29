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


    public void addSpareFrame(int firstRoll) {
        frames.add(new SpareFrame (pinsKnockedDown, firstRoll));
    }

    public void addStrikeFrame() {
        frames.add(new StrikeFrame (pinsKnockedDown));
    }


    public void addBonus(int score) {
        // Don't need to add to frames, since these scores form part of a previous frame
        pinsKnockedDown.add(score);
    }


    public int sum() {
        int total=0;

        for (Frame frame : frames) {
            total += frame.sum();
        }
        return total;
    }
}
