package goc.GameofChance.model;

public class NumberGuessModel {
    private int targetNumber;
    private int userGuesses;
    private int correctGuesses;

    public NumberGuessModel() {
        this.targetNumber = generateRandomNumber(1, 30);
        this.userGuesses = 0;
        this.correctGuesses = 0;
    }

    public boolean isGameFinished() {
        return userGuesses >= 5 || correctGuesses == 3;
    }

    public boolean makeGuess(int guess) {
        userGuesses++;
        if (guess == targetNumber) {
            correctGuesses++;
            return true;
        }
        return false;
    }

    public int getTargetNumber() {
        return targetNumber;
    }

    public int getCorrectGuesses() {
        return correctGuesses;
    }

    public int getUserGuesses() {
        return userGuesses;
    }

    private int generateRandomNumber(int min, int max) {
        return min + (int) (Math.random() * (max - min + 1));
    }
}
