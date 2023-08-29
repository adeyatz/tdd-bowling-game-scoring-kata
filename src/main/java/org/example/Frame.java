package org.example;

import java.util.ArrayList;

public abstract class Frame {
    protected int indexToPinsScores;
    protected ArrayList <Integer> pinScores;

    protected final static int NUMBER_OF_PINS = 10;

    public Frame(ArrayList<Integer>pinScores) {
        this.pinScores = pinScores;
        this.indexToPinsScores = pinScores.size();
    }

    abstract int sum();
}
