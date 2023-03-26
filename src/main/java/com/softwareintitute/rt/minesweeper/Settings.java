package com.softwareintitute.rt.minesweeper;

public class Settings {

    private static int boardLength = 8;
    private static int boardWidth = 8;
    private static Difficulty gameDifficulty = Difficulty.BEGINNER;

    public static int getBoardLength() {
        return boardLength;
    }

    public static int getBoardWidth() {
        return boardWidth;
    }

    public static Difficulty getGameDifficulty() {
        return gameDifficulty;
    }

    public static void setBoardLength(int boardLength) throws InvalidBoardSize {

        if (boardLength >= 5 && boardLength <= 30) {
            Settings.boardLength = boardLength;
        } else {
            throw new InvalidBoardSize();
        }

    }

    public static void setBoardWidth(int boardWidth) throws InvalidBoardSize {

        if (boardWidth >= 5 && boardWidth <= 30) {
            Settings.boardWidth = boardWidth;
        } else {
            throw new InvalidBoardSize();
        }


    }

    public static void setGameDifficulty(int gameDifficulty) throws InvalidDifficultyLvl {

        if (gameDifficulty >= 1 && gameDifficulty <= 3) {
            switch (gameDifficulty) {
                case 2 -> Settings.gameDifficulty = Difficulty.INTERMEDIATE;
                case 3 -> Settings.gameDifficulty = Difficulty.HARD;
                default -> Settings.gameDifficulty = Difficulty.BEGINNER;
            }
        } else {
            throw new InvalidDifficultyLvl();
        }
    }
}



