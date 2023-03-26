package com.softwareintitute.rt.minesweeper;

import com.softwareintitute.rt.minesweeper.game.settings.Difficulty;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DifficultyTest {

    @Test
    void testing_difficulty_getString(){

        assertEquals("Hard",Difficulty.HARD.getDifficultyLvlAsString(),"The String should match");
    }

    @Test
    void testing_difficulty_getValue(){

        assertEquals(10,Difficulty.BEGINNER.getValue(),"The expected values should match");
    }


}
