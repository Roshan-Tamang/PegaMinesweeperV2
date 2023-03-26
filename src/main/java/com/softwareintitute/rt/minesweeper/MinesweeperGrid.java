package com.softwareintitute.rt.minesweeper;

import java.util.*;

public class MinesweeperGrid {


    private int width;
    private int length;
    private Tile[][] board;
    private int numberOfMines;

    public MinesweeperGrid(int length, int width, int numberOfMines) {
        this.length = length;
        this.width = width;
        this.numberOfMines = numberOfMines;
        board = new Tile[this.length][this.width];
        initaliseTiles();
        placeMines();
        calculateNeighbours();
    }

    private void initaliseTiles() {
        for (int i = 0; i < this.length; i++) {
            for (int j = 0; j < this.width; j++) {
                board[i][j] = new Tile();
            }
        }
    }

    private void placeMines() {
        //check less mines than squares of grid are requested
        int bombsPlaced = 0;
        Random randomNumber = new Random();
        int currentX;
        int currentY;
        while (bombsPlaced < numberOfMines) {
            currentX = randomNumber.nextInt(length);
            currentY = randomNumber.nextInt(width);
            if (!board[currentX][currentY].isABomb()) {
                board[currentX][currentY].setABomb(true);
                bombsPlaced++;
            }
        }
    }

    private void calculateNeighbours() {

        for (int i = 0; i < this.length; i++) {
            for (int j = 0; j < this.width; j++) {
                for (int x = i - 1; x <= i + 1; x++) {
                    for (int y = j - 1; y <= j + 1; y++) {
                        if (x < 0 || y < 0 || x >= length || y >= width) {//checks to see if the tile is out of bounds and we only count when in bounds

                        } else if (x == i && y == j) {//we dont want to count the center square

                        } else {
                            if (board[x][y].isABomb()) {
                                board[i][j].increaseNeighbour();
                            }
                        }

                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.length; i++) {
            for (int j = 0; j < this.width; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public String revealSquare(int xCord, int yCord) {

        String gameMessage = "Continue";

        if (!board[xCord][yCord].isFlagged()) {
            board[xCord][yCord].revealTile();
            if (board[xCord][yCord].isABomb()) {
                gameMessage = gameOver();
            } else if (board[xCord][yCord].getNumberOfNeighbouringMines() == 0) {
                revealAdditionalSquares(xCord, yCord);
            }
        }

        if(gameMessage.equals("Continue")){
            gameMessage = checkIfGameHasBeenWon();
        }

        return gameMessage;
    }

    private String checkIfGameHasBeenWon() {

        int numberOfRevealedTiles = 0;

        for (Tile[] i :
                board) {
            for (Tile j : i) {
                if(j.isRevealed()){
                    numberOfRevealedTiles++;
                }
            }
        }

        if (numberOfRevealedTiles - numberOfMines == length * width){
            return "Congratulations!";
        }

        return "Continue";
    }

    private void revealAdditionalSquares(int xCord, int yCord) {


        List<String> listOfCordsWithZeroNeighbourMines = new ArrayList<>();


        listOfCordsWithZeroNeighbourMines.add(String.valueOf(xCord) + yCord);


        for (int i = 0; i < listOfCordsWithZeroNeighbourMines.size(); i++) {


            int currentX = Integer.parseInt(String.valueOf(listOfCordsWithZeroNeighbourMines.get(i).charAt(0)));
            int currentY = Integer.parseInt(String.valueOf(listOfCordsWithZeroNeighbourMines.get(i).charAt(1)));

            for (int x = currentX - 1; x <= currentX + 1; x++) {
                for (int y = currentY - 1; y <= currentY + 1; y++) {
                    if (x < 0 || y < 0 || x >= length || y >= width) {//checks to see if the tile is out of bounds and we only count when in bounds

                    } else if (x == currentX && y == currentY) {//we dont want to count the center square

                    } else if (!board[x][y].isRevealed() && !board[x][y].isABomb()) {
                        board[x][y].revealTile();
                        if (board[x][y].getNumberOfNeighbouringMines() == 0) {
                            listOfCordsWithZeroNeighbourMines.add(String.valueOf(x) + y);
                        }
                    }
                }
            }
        }
    }


    public void setFlag(int xCord, int yCord) {

        board[xCord][yCord].flagTile();

    }

    public String gameOver() {
        for (int i = 0; i < this.length; i++) {
            for (int j = 0; j < this.width; j++) {
                board[i][j].revealTile();
            }
        }
        return "Game Over!";
    }
}
