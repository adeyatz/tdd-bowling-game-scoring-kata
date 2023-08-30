package org.example;

class BowlingLineParser {
    public void parse(BowlingLineCalculator calculator, String lineScore) {
        // This doesn't check for correct number of frames!!!
        // All frames separated by SPACE
        // X X X X X X X X X X X X  (12 Strikes)
        // 9- 9- 9- 9- 9- 9- 9- 9- 9- 9-
        // 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5  21 rolls, 10 pairs of 5 and Spare, final 5

        String [] frameScores = lineScore.replace('-','0').split(" ");

        int frameCount = 0;

        for (String frameScore : frameScores) {
            if (++frameCount > 10)
            {
                // bonus balls
                int bonus = frameScore.matches("X|/") ? 10 : Integer.parseInt(frameScore);
                calculator.addBonus(bonus);
            } else {
                if (frameScore.matches("X")) {
                    calculator.addStrikeFrame();
                } else {
                    char[] rolls = frameScore.toCharArray();

                    int roll0 = rolls[0] - '0';
                    if (rolls[1] == '/') {
                        calculator.addSpareFrame(roll0);
                    } else {
                        calculator.addStandardFrame(roll0, rolls[1] - '0');
                    }
                }
            }
        }
    }
}
