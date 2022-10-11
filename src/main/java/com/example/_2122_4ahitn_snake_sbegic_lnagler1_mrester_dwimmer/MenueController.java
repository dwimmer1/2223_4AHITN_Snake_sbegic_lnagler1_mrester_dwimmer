package com.example._2122_4ahitn_snake_sbegic_lnagler1_mrester_dwimmer;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class MenueController {

    @FXML
    public Button btExit;

    @FXML
    public ChoiceBox cbChooseSpeed;

    @FXML
    public Button btMusicOnOff;

    @FXML
    public Slider slVolume;

    @FXML
    public Button playBTN;

    @FXML
    public ImageView imageView;

    Boolean music_status = true;   //gets Value from Menue-Input (Default Value = true)

    private Media media;

    private MediaPlayer mp;

    /**
     * String-Array for GIF's
     */
    public String[] gifs = {
            "src/main/resources/com/example/_2122_4ahitn_snake_sbegic_lnagler1_mrester_dwimmer/GIFs/Easy-Mode-GIF.gif",
            "src/main/resources/com/example/_2122_4ahitn_snake_sbegic_lnagler1_mrester_dwimmer/GIFs/Normal-Mode-GIF.gif",
            "src/main/resources/com/example/_2122_4ahitn_snake_sbegic_lnagler1_mrester_dwimmer/GIFs/Difficult-Mode-GIF.gif",
            "src/main/resources/com/example/_2122_4ahitn_snake_sbegic_lnagler1_mrester_dwimmer/GIFs/yasuo_face_the_wind.gif"
    };
    /**
     * String-Array for Songs
     */
    public String[] songs = {
            "src/main/resources/com/example/_2122_4ahitn_snake_sbegic_lnagler1_mrester_dwimmer/music/Easy-Mode-Music.mp3",
            "src/main/resources/com/example/_2122_4ahitn_snake_sbegic_lnagler1_mrester_dwimmer/music/Normal-Mode-Music.mp3",
            "src/main/resources/com/example/_2122_4ahitn_snake_sbegic_lnagler1_mrester_dwimmer/music/Difficult-Mode-Music.mp3",
            "src/main/resources/com/example/_2122_4ahitn_snake_sbegic_lnagler1_mrester_dwimmer/music/0_10Yasuo-Mode-Music.mp3"
    };


    public void initialize() throws IOException {
        cbChooseSpeed.setItems(FXCollections.observableArrayList(
                "Leicht", "Normal", "Schwer", "0/10Yasuo"));
        cbChooseSpeed.setValue("Leicht");

        setDefault(songs, gifs);
        setSongAndGif(gifs, songs);
    }

    private void setDefault(String[] songs, String[] gifs) {
        // sets default Music and GIF when running program
        imageView.setImage(new Image(new File(gifs[0]).toURI().toString()));
        media = new Media(new File(songs[0]).toURI().toString());
        createMediaPlayer();
        setVolume4Song();
    }

    private void selectFromDifficultyInput(String[] gifs, String[] songs, int new_val) {
        mp.stop();
        imageView.setImage(null);
        imageView.setImage(new Image(new File(gifs[Integer.parseInt(String.valueOf(new_val))]).toURI().toString()));
        media = new Media(new File(songs[Integer.parseInt(String.valueOf(new_val))]).toURI().toString());
        createMediaPlayer();
    }

    private void setSongAndGif(String[] gifs, String[] songs) {
        cbChooseSpeed.getSelectionModel().selectedIndexProperty().addListener(
                (ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
                    if (Integer.parseInt(String.valueOf(new_val)) == 0) {
                        selectFromDifficultyInput(gifs, songs, Integer.parseInt(String.valueOf(new_val)));
                    } else if (Integer.parseInt(String.valueOf(new_val)) == 1) {
                        selectFromDifficultyInput(gifs, songs, Integer.parseInt(String.valueOf(new_val)));
                    } else if (Integer.parseInt(String.valueOf(new_val)) == 2) {
                        selectFromDifficultyInput(gifs, songs, Integer.parseInt(String.valueOf(new_val)));
                    } else if (Integer.parseInt(String.valueOf(new_val)) == 3) {
                        selectFromDifficultyInput(gifs, songs, Integer.parseInt(String.valueOf(new_val)));
                    }
                });
    }

    private void setVolume4Song() {
        slVolume.setValue(mp.getVolume() * 100);
        slVolume.valueProperty().addListener(observable -> mp.setVolume(slVolume.getValue() / 100));
        System.out.println(mp.getStatus());
    }


    public void switchToPlayfield() throws IOException {
        Stage s = (Stage) btExit.getScene().getWindow();
        s.close();
        PlayFieldController play = new PlayFieldController();
        play.loadPlayField();
    }

    public void closeMenue(ActionEvent actionEvent) {
        Stage s = (Stage) btExit.getScene().getWindow();
        s.close();
    }

    public void musicOnOff(ActionEvent actionEvent) {
        music_status = !music_status;
        if (music_status) {
            createMediaPlayer();
        } else {
            mp.stop();
        }
    }

    public void createMediaPlayer() {
        mp = new MediaPlayer(media);
        mp.setAutoPlay(music_status);
        mp.setVolume(0.5);
        slVolume.setValue(mp.getVolume() * 100);
        mp.setCycleCount(MediaPlayer.INDEFINITE);
    }
}
