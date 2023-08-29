package org.example;

import java.util.ArrayList;

public class StrikeFrame extends Frame {
    public StrikeFrame(ArrayList<Integer> pinsDownList) {
        super(pinsDownList);
        pinScores.add(10);
    }

    @Override
    int sum() {
        return pinScores.get(indexToPinsScores)
                + pinScores.get(indexToPinsScores + 1)
                + pinScores.get(indexToPinsScores + 2);
    }
}
