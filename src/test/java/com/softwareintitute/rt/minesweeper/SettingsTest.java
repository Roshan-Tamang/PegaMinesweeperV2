package com.softwareintitute.rt.minesweeper;

import com.softwareintitute.rt.minesweeper.exceptions.InvalidBoardSize;
import com.softwareintitute.rt.minesweeper.exceptions.InvalidDifficultyLvl;
import com.softwareintitute.rt.minesweeper.game.settings.Difficulty;
import com.softwareintitute.rt.minesweeper.game.settings.Settings;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SettingsTest {

    @Test
    void testing_settings_getBoardWidth() throws InvalidBoardSize {

        Settings.setBoardWidth(5);

        assertEquals(5,Settings.getBoardWidth(),"The values should match");
    }

    @Test
    void testing_settings_getBoardLength() throws InvalidBoardSize {

        Settings.setBoardLength(5);

        assertEquals(5,Settings.getBoardLength(),"The values should match");

    }


    @Test
    void testing_settings_getGameDifficulty() throws InvalidDifficultyLvl {

        Settings.setGameDifficulty(1);

        assertEquals(Difficulty.BEGINNER,Settings.getGameDifficulty(),"The difficulty should match");

    }


}
