package com.softwareintitute.rt.minesweeper;

public class Game {

    private int score;
    MinesweeperGrid minesweeperGrid;
    Settings settings;


    public Game() {
        initaliseGame();
    }

    private void initaliseGame() {
        score = 0;
        settings = new Settings();
    }


    public String mainMenu() {

        String mainMenu = "Welcome to Minesweeper! Please enter the number to select an option:" + System.lineSeparator() +
                "0: Play Minesweeper" + System.lineSeparator() +
                "1: Set board size" + System.lineSeparator() +
                "2: Set difficulty level" + System.lineSeparator() +
                "4: Exit";

        return mainMenu;

    }


    public void start() {

        int numberOfMines = calculateNumberOfMines();

        minesweeperGrid = new MinesweeperGrid(Settings.getBoardLength(), Settings.getBoardWidth(), numberOfMines);


    }

    private int calculateNumberOfMines() {

        int numberOfTiles = Settings.getBoardLength() * Settings.getBoardWidth();

        int numberOfMines = numberOfTiles * Settings.getGameDifficulty().getValue() / 100;
        if (numberOfMines < 3) {
            numberOfMines = 3;
        }

        return numberOfMines;

    }

    public void takeTurn(int xCord, int YCord) {
        minesweeperGrid.toString();

    }

}

