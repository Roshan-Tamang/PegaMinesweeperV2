package com.softwareintitute.rt.minesweeper.game;

import com.softwareintitute.rt.minesweeper.exceptions.InvalidCoordinate;
import com.softwareintitute.rt.minesweeper.game.data.MinesweeperGrid;
import com.softwareintitute.rt.minesweeper.game.settings.Difficulty;
import com.softwareintitute.rt.minesweeper.game.settings.Settings;

public class Game {

    private int score;
    private MinesweeperGrid minesweeperGrid;

    private boolean isGameWon;
    private boolean isGameOver;

    public Game() {
        this.isGameOver = false;
        initaliseGame();
    }

    private void initaliseGame() {
        score = 0;
    }


    public String mainMenu() {

        String mainMenu = "Welcome to Minesweeper! Please enter the number to select an option:" + System.lineSeparator() +
                "0: Play Minesweeper" + System.lineSeparator() +
                "1: Set board size" + System.lineSeparator() +
                "2: Set difficulty level" + System.lineSeparator() +
                "3: Exit";

        return mainMenu;

    }


    public String start() {
        int numberOfMines = calculateNumberOfMines();
        minesweeperGrid = new MinesweeperGrid(Settings.getBoardLength(), Settings.getBoardWidth(), numberOfMines);


        return minesweeperGrid.toString();
    }

    private int calculateNumberOfMines() {

        int numberOfTiles = Settings.getBoardLength() * Settings.getBoardWidth();

        int numberOfMines = numberOfTiles * Settings.getGameDifficulty().getValue() / 100;
        if (numberOfMines < 3) {
            numberOfMines = 3;
        }

        return numberOfMines;

    }

    public String takeTurn(String option, int xCord, int yCord) throws InvalidCoordinate {

        String gameEndMessage;

        if (xCord < 0 || xCord >= Settings.getBoardLength() || yCord < 0 || yCord >= Settings.getBoardWidth()) {
            throw new InvalidCoordinate();
        } else {
            if (option.equals("Reveal")) {
                gameEndMessage = minesweeperGrid.revealSquare(xCord, yCord);
                if (gameEndMessage.equals("Game Over!")) {
                    isGameOver = true;
                } else if (gameEndMessage.equals("Congratulations!")) {
                    isGameWon = true;
                } else if (gameEndMessage.equals("Continue")) {
                    updateScore();
                }

            } else if (option.equals("Flag")) {
                minesweeperGrid.setFlag(xCord, yCord);
            }
        }
       return minesweeperGrid.toString();
    }

    private void updateScore() {

        int numberOfRevealedTiles = minesweeperGrid.getNumberOfRevealedTiles();

        score = (Settings.getGameDifficulty() == Difficulty.BEGINNER) ? (numberOfRevealedTiles) : (Settings.getGameDifficulty() == Difficulty.INTERMEDIATE) ? (2*numberOfRevealedTiles):(3*numberOfRevealedTiles);

    }

    public int getScore() {
        return score;
    }

    public boolean checkIfGameIsWon(){
        return isGameWon;
    }
    public boolean checkIfGameIsOver(){
        return isGameOver;
    }

}

