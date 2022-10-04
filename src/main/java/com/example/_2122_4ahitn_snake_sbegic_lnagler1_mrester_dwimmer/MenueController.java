package com.example._2122_4ahitn_snake_sbegic_lnagler1_mrester_dwimmer;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class MenueController {


    public Button btExit;
    public ChoiceBox cbChooseSpeed;
    public Button btMusicOnOff;
    public Slider slVolume;
    public Button playBTN;

    public void initialize() throws IOException {
        cbChooseSpeed.setItems(FXCollections.observableArrayList(
                "Leicht", "Normal", "Schwer", "0/10Yasuo"));
        }


    public void switchToPlayfield() throws IOException {
        PlayFieldController play = new PlayFieldController();
        play.loadPlayField();
    }

    public void closeMenue(ActionEvent actionEvent) {
        Stage s = (Stage) btExit.getScene().getWindow();
        s.close();
    }

    public void musicOnOff(ActionEvent actionEvent) {

    }
}
