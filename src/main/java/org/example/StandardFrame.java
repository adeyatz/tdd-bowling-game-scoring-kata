package org.example;

import java.util.ArrayList;

public class StandardFrame extends Frame {
    public StandardFrame(ArrayList<Integer> pinScores, int firstRoll, int secondRoll) {
        super(pinScores);
        this.pinScores.add(firstRoll);
        this.pinScores.add(secondRoll);
    }

    @Override
    int sum() {
        return pinScores.get(indexToPinsScores) + pinScores.get(indexToPinsScores + 1);
    }
}
