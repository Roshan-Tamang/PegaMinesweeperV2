package com.softwareintitute.rt.minesweeper;


public class Tile {

    private boolean isRevealed;

    private boolean isFlagged;

    private boolean isABomb;

    private int numberOfNeighbouringMines;

    public Tile(){
        this.isRevealed = false;
        this.isFlagged = false;
        this.isABomb = false;
        this.numberOfNeighbouringMines = 0;
    }

    public void flagTile(){
        if(!isRevealed){
           isFlagged = !isFlagged;
        }
    }

    public void revealTile(){
        if(!isRevealed){
            isRevealed = true;
        }
    }


    public void setABomb(boolean ABomb) {
        isABomb = ABomb;
    }

    public void setNumberOfNeighbouringMines(int numberOfNeighbouringMines) {
        this.numberOfNeighbouringMines = numberOfNeighbouringMines;
    }
     public void increaseNeighbour(){
        numberOfNeighbouringMines++;
     }
    public boolean isRevealed() {
        return isRevealed;
    }

    public boolean isFlagged() {
        return isFlagged;
    }

    public boolean isABomb() {
        return isABomb;
    }

    public int getNumberOfNeighbouringMines() {
        return numberOfNeighbouringMines;
    }

    @Override
    public String toString() {
        if (!isRevealed){
            return (isFlagged)?"F":"?";
        }
        else if (isABomb){
            return "B";
        }
        else{
            return ""+numberOfNeighbouringMines;
        }
    }
}
