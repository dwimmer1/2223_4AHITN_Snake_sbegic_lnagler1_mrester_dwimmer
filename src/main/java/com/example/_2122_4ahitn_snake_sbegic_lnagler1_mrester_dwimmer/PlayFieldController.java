package com.example._2122_4ahitn_snake_sbegic_lnagler1_mrester_dwimmer;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class PlayFieldController {

    GridPane gridPane = new GridPane();
    HBox hbox = new HBox();
    VBox vBox = new VBox();

    public void initialize(){
       Playfield playfield = new Playfield();
        gridPane = playfield.createGridPane(15, 15);
        System.out.println(gridPane.toString());
        vBox.getChildren().add(gridPane);
        hbox.getChildren().add(vBox);
        System.out.println("Bin drin");
    }
}
