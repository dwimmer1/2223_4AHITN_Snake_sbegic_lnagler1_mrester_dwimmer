package com.example._2122_4ahitn_snake_sbegic_lnagler1_mrester_dwimmer;

import java.io.IOException;

public class MenueController {




    public void switchToPlayfield() throws IOException {
        PlayFieldController play = new PlayFieldController();
        play.loadPlayField();
    }
}
