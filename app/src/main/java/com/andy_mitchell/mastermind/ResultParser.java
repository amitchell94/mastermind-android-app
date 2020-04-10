package com.andy_mitchell.mastermind;

public class ResultParser {

    public static String getStringFromGuessResult(GuessResult guessResult) {
        String str = getStringFromColourArray(guessResult.getGuess());

        return str;
    }

    private static String getStringFromColourArray(Colours[] colourArray) {
        String str = "";
        for (Colours colour: colourArray) {
            str += getStringFromColour(colour) + " ";
        }
        return str;
    }

    private static String getStringFromColour (Colours colour) {
        switch (colour) {
            case BLACK:
                return "Black";
            case RED:
                return "Red";
            case BLUE:
                return "blue";
            case GREEN:
                return "green";
            case WHITE:
                return "white";
            case YELLOW:
                return "yellow";
        }
        return null;
    }
}
