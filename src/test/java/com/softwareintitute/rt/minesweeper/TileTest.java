package com.softwareintitute.rt.minesweeper;

import com.softwareintitute.rt.minesweeper.game.data.Tile;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TileTest {


    @Test
    void testing_tile_bomb() {

        Tile tile = new Tile();

        tile.setABomb(true);

        assertTrue(tile.isABomb(), "It should be true");

    }

    @Test
    void testing_tile_flag() {

        Tile tile = new Tile();

        tile.flagTile();

        assertTrue(tile.isFlagged(), "It should be true");


    }

    @Test
    void testing_tile_gettingNumberOfNeighbouringMines(){

        Tile tile = new Tile();

        tile.setNumberOfNeighbouringMines(2);

        assertEquals(2,tile.getNumberOfNeighbouringMines(),"The values should match");

    }


    @Test
    void testing_tile_revealTile(){

        Tile tile = new Tile();

        tile.revealTile();

        assertTrue(tile.isRevealed(),"It should be true");

    }



}
