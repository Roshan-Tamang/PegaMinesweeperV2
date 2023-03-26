package com.softwareintitute.rt.minesweeper;

import com.softwareintitute.rt.minesweeper.game.data.MinesweeperGrid;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinesweeperGridTest {

    @Test
    void testing_minesweepergrid_gettingNumberOfRevealedTiles() {

        MinesweeperGrid minesweeperGrid = new MinesweeperGrid(5,5,3);

        assertEquals(0,minesweeperGrid.getNumberOfRevealedTiles(),"The values should match");

    }

    @Test
    void testing_minesweepergrid_revealSquare(){

        MinesweeperGrid minesweeperGrid = new MinesweeperGrid(5,5,3);

        assertEquals("Continue",minesweeperGrid.revealSquare(2,2),"Continue should be returned by the method");

    }



}
