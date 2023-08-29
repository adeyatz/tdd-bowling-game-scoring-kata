package org.example;

import java.util.ArrayList;

public class StandardFrame extends Frame {
    public StandardFrame(ArrayList<Integer> pinsDownList, int firstRoll, int secondRoll) {
        super(pinsDownList);
        pinScores.add(firstRoll);
        pinScores.add(secondRoll);
    }

    @Override
    int sum() {
        return pinScores.get(indexToPinsScores) + pinScores.get(indexToPinsScores + 1);
    }
}
