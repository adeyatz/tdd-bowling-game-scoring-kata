package org.example;

public class BowlingGame {
    private String bowlerName;



    public BowlingGame (String name) {
        this.bowlerName = name;
    }

    public String getBowlerName() {
        return bowlerName;
    }


    public int calculateSum (String lineScore)
    {
        BowlingLineCalculator calc = new BowlingLineCalculator();

        BowlingLineParser scoreParser = new BowlingLineParser();

        scoreParser.parse (calc, lineScore);

        return calc.sum();
    }
}
