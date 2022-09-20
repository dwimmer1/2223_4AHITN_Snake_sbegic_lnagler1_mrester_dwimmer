package com.example._2122_4ahitn_snake_sbegic_lnagler1_mrester_dwimmer;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class Playfield {
    GridPane gridPane = new GridPane();
    public GridPane createGridPane(int cols, int rows){
        gridPane.setDisable(false);
        for (int column = 0; column < cols ; column++) {
            for (int row = 0; row < rows; row++) {
                Pane pane = new Pane();
                pane.setStyle("-fx-background-color: blue");
                gridPane.add(pane, row, column);
                gridPane.setGridLinesVisible(true);
            }
        }
        return gridPane;
    }
}
