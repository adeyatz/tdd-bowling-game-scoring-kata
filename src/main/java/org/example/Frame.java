package org.example;

import java.util.ArrayList;

public abstract class Frame {
    protected int indexToPinsScores;
    protected ArrayList <Integer> pinScores;

    public Frame(ArrayList<Integer>pinScores) {
        this.pinScores = pinScores;
        this.indexToPinsScores = pinScores.size();
    }

    abstract int sum();
}
