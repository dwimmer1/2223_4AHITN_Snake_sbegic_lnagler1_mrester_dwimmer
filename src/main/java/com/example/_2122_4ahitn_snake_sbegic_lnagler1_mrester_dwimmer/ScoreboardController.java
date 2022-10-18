package com.example._2122_4ahitn_snake_sbegic_lnagler1_mrester_dwimmer;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;

public class ScoreboardController {

    @FXML
    public ImageView imageView;

    @FXML
    public Label label;

    @FXML
    public Button exitBTN;

    Media media;

    MediaPlayer mediaPlayer;

    public void initialize() {
        MenueController.mp.stop();
        media = new Media(new File("src/main/resources/com/example/_2122_4ahitn_snake_sbegic_lnagler1_mrester_dwimmer/music/you-died-hd.mp3").toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setVolume(0.5);
        mediaPlayer.play();
        imageView.setImage(new Image(new File("src/main/resources/com/example/_2122_4ahitn_snake_sbegic_lnagler1_mrester_dwimmer/GIFs/You Died.gif").toURI().toString()));
        label.setText("Score: " + " " + " Points");
    }

    public void closeScoreboard(){
        Stage s = (Stage) exitBTN.getScene().getWindow();
        s.close();
    }
}
