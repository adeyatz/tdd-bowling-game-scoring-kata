package org.example;

import java.util.ArrayList;

public class BowlingLineCalculator {
    private ArrayList<Integer> pinScores;
    private ArrayList<Frame> frames;

    public BowlingLineCalculator() {
        pinScores = new ArrayList<Integer>();
        frames = new ArrayList<Frame>();
    }

    public void addStandardFrame(int firstRoll, int secondRoll) {
        frames.add(new StandardFrame (pinScores, firstRoll, secondRoll));
    }


    public void addSpareFrame(int firstRoll) {
        frames.add(new SpareFrame (pinScores, firstRoll));
    }

    public void addStrikeFrame() {
        frames.add(new StrikeFrame (pinScores));
    }


    public void addBonus(int score) {
        // Don't need to add to frames, since these scores form part of a previous frame
        pinScores.add(score);
    }


    public int sum() {
        int total=0;

        for (Frame frame : frames) {
            total += frame.sum();
        }
        return total;
    }
}
