package com.example._2122_4ahitn_snake_sbegic_lnagler1_mrester_dwimmer;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

/**
 * @author lngler1
 */
public class Playfield {

    /**
     * Draws the Background of the PlayField with a GridPane like Background.
     *
     * @param cols       Number off columns the PlayField should have.
     * @param rows       Number of rows the PlayField should have.
     * @param gc         Graphicscontext for the PlayField
     * @param squareSize The height and width From each square of the PlayField.
     */

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

    public void drawGrid(int x, int y, GraphicsContext gc, int squareSize) {
        if ((x + y) % 2 == 0) {
            System.out.println("Hallo");
            Color c = Color.web("#a2d049");
            gc.setFill(c);
        } else {
            Color c = Color.web("#a9d751");
            gc.setFill(c);
        }
        System.out.println(x * squareSize);
        gc.fillRect(x * squareSize, y * squareSize, squareSize, squareSize);
    }

    /**
     * Draws the Food onto the PlayField.
     *
     * @param graphicsContext graphicsContext with the PlayField
     * @param squareSize      The Size of each Square of the PlayField
     * @param food            has the place where the Food should be placed saved.
     */
    public void drawFood(GraphicsContext graphicsContext, int squareSize, Food food) {
        graphicsContext.drawImage(food.getFoodImage(), food.getFoodX() * squareSize, food.getFoodY() * squareSize, squareSize, squareSize);
    }
}
