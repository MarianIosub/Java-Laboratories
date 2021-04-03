package com.company;

import java.util.Random;

public class Token {
    private Integer leftValue;
    private Integer rightValue;
    private Integer scoreValue;
    private Integer maxValue;

    public Token(Integer maxValue) {
        this.maxValue = maxValue;
        Random random = new Random();
        leftValue = random.nextInt(maxValue) + 1;
        rightValue = leftValue;
        while (rightValue == leftValue) {
            rightValue = random.nextInt(maxValue) + 1;
        }
        scoreValue = random.nextInt(10);
    }


    @Override
    public String toString() {
        return
                leftValue +
                        "/" + rightValue +
                        " with score: " + scoreValue
                ;
    }

    public Integer getLeftValue() {
        return leftValue;
    }

    public Integer getRightValue() {
        return rightValue;
    }

    public Integer getScoreValue() {
        return scoreValue;
    }

    public void setLeftValue(Integer leftValue) {
        this.leftValue = leftValue;
    }

    public void setRightValue(Integer rightValue) {
        this.rightValue = rightValue;
    }

    public void setScoreValue(Integer scoreValue) {
        this.scoreValue = scoreValue;
    }
}
