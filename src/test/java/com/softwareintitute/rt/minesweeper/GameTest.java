package com.softwareintitute.rt.minesweeper;

import com.softwareintitute.rt.minesweeper.game.Game;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class GameTest {

    @Test
    void testing_game_getScore(){

        Game game = new Game();

        assertEquals(0,game.getScore(),"The values should match");

    }

    @Test
    void testing_game_checkIfGameIsWon(){

        Game game = new Game();

        assertFalse(game.checkIfGameIsWon(),"It should be false");

    }


    @Test
    void testing_game_checkIfGameIsOver(){

        Game game = new Game();

        assertFalse(game.checkIfGameIsOver(), "It should be false");

    }

}
