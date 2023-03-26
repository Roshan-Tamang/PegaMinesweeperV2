package com.softwareintitute.rt.minesweeper.game.settings;

public enum Difficulty {

    BEGINNER(10, "Beginner"),
    INTERMEDIATE(20, "Intermediate"),
    HARD(30, "Hard");

    private int value;
    private String difficultyLvlAsString;

    Difficulty(int value, String difficultyLvlAsString) {
        this.value = value;
        this.difficultyLvlAsString = difficultyLvlAsString;
    }

    public int getValue() {
        return value;
    }

    public String getDifficultyLvlAsString() {
        return difficultyLvlAsString;
    }
}

