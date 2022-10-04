package com.example._2122_4ahitn_snake_sbegic_lnagler1_mrester_dwimmer;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class Playfield {

    public void drawBackground(int cols, int rows, GraphicsContext gc, int squareSize) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if ((i + j) % 2 == 0) {
                    Color c = Color.web("#a2d049");
                    gc.setFill(c);
                } else {
                    Color c = Color.web("#a9d751");
                    gc.setFill(c);
                }
                gc.fillRect(i * squareSize, j * squareSize, squareSize, squareSize);
            }
        }
    }

    public void drawFood(GraphicsContext graphicsContext, int squareSize, Food food) {
        graphicsContext.drawImage(food.getFoodImage(), food.getFoodX() * squareSize, food.getFoodY() * squareSize, squareSize, squareSize);
    }
}
