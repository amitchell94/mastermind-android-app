package com.andy_mitchell.mastermind;

public class EvaluationResult {

        private int correctColoursInTheRightPlace;
        private int correctColoursInTheWrongPlace;

        public int getCorrectColoursInTheRightPlace() {
            return correctColoursInTheRightPlace;
        }

        public void setCorrectColoursInTheRightPlace(int correctColoursInTheRightPlace) {
            this.correctColoursInTheRightPlace = correctColoursInTheRightPlace;
        }

        public int getCorrectColoursInTheWrongPlace() {
            return correctColoursInTheWrongPlace;
        }

        public void setCorrectColoursInTheWrongPlace(int correctColoursInTheWrongPlace) {
            this.correctColoursInTheWrongPlace = correctColoursInTheWrongPlace;
        }

        public void incrementColoursInTheWrongPlace(){
            correctColoursInTheWrongPlace += 1;
        }

        public void incrementColoursInTheRightPlace(){
            correctColoursInTheRightPlace += 1;
        }

}
