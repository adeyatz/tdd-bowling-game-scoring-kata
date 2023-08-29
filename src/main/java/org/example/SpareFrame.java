package org.example;

import java.util.ArrayList;

public class SpareFrame extends Frame {
    public SpareFrame(ArrayList<Integer> pinsDownList, int firstRoll) {
        super(pinsDownList);
        pinScores.add(firstRoll);
        pinScores.add(10 - firstRoll);
    }

    @Override
    int sum() {
        return pinScores.get(indexToPinsScores)
                + pinScores.get(indexToPinsScores + 1)
                + pinScores.get(indexToPinsScores + 2);
    }
}
