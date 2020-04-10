package com.andy_mitchell.mastermind;

import android.graphics.Color;

public class ResultParser {

    public static int[] getIntColorArrayFromEvaluationResult(EvaluationResult evaluationResult) {
        int correctPieces = evaluationResult.getCorrectColoursInTheRightPlace();
        int almostCorrectPieces = evaluationResult.getCorrectColoursInTheWrongPlace();
        int[] intColorArray = new int[4];
        for (int i = 0; i < intColorArray.length; i++) {
            if (correctPieces == 0 && almostCorrectPieces == 0){
                intColorArray[i] = Color.GRAY;
            } else if (correctPieces > 0) {
                intColorArray[i] = Color.BLACK;
                correctPieces -= 1;
            } else {
                intColorArray[i] = Color.WHITE;
                almostCorrectPieces -= 1;
            }
        }

        return intColorArray;
    }

    public static int[] getIntColorArrayFromColourArray(Colours[] colourArray) {
        int[] intColorArray = new int[colourArray.length];
        for (int i = 0; i < colourArray.length; i++) {
            intColorArray[i] = getIntColorFromColour(colourArray[i]);
        }
        return intColorArray;
    }

    private static int getIntColorFromColour (Colours colour) {
        switch (colour) {
            case BLACK:
                return Color.BLACK;
            case RED:
                return Color.RED;
            case BLUE:
                return Color.BLUE;
            case GREEN:
                return Color.GREEN;
            case WHITE:
                return Color.WHITE;
            case YELLOW:
                return Color.YELLOW;
        }
        return 0;
    }
}
