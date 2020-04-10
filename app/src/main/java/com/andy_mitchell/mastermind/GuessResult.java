package com.andy_mitchell.mastermind;

public class GuessResult {
    private Colours[] guess;
    private EvaluationResult result;

    public GuessResult(Colours[] guess, EvaluationResult result) {
        this.guess = guess;
        this.result = result;
    }

    public Colours[] getGuess() {
        return guess;
    }

    public EvaluationResult getResult() {
        return result;
    }
}

