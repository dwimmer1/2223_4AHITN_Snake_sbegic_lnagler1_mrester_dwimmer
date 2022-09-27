package com.example._2122_4ahitn_snake_sbegic_lnagler1_mrester_dwimmer;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MenueController {

    @FXML
    Slider volumeSlider;

    Boolean music_status = true;   //gets Value from Menue-Input (Default Value = true)

    private final String bg_music_path = "src/main/resources/com/example/_2122_4ahitn_snake_sbegic_lnagler1_mrester_dwimmer/title-music-party-time.mp3";

    private MediaPlayer mp;

    private Media media;

    public void initialize() throws IOException {

        media = new Media(new File(bg_music_path).toURI().toString());
        mp = new MediaPlayer(media);
        mp.setAutoPlay(music_status);


    }

    ;


    /**
     * Function for Music ON/OFF
     * music_status = !music_status;
     * musicplayer.isPlaying()
     * if (music_status){
     * startPlaying(musicplayer.music_file);
     * } else{
     * musicplayer.stop();
     * }
     */


    public void switchToPlayfield() throws IOException {
        HelloApplication.setRoot("playField-view");

    }
}
