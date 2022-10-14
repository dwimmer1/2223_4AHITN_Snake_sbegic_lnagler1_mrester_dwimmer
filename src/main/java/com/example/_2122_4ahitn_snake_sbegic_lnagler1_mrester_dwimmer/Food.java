package com.example._2122_4ahitn_snake_sbegic_lnagler1_mrester_dwimmer;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.io.File;

/**
 * @author lnagler1
 * The Food which the Snake has to eat to get bigger.
 */
public class Food {
    private final String[] foodString = {"assets/icon/MciResize.png", "assets/icon/apple.png"};
    private static int foodX;
    private static int foodY;
    private Image foodImage;

    /**
     * Random X and Y coordinates are created to display the Food at.
     *
     * @param rows The number off rows the PlayField has.
     * @param cols The number off columns the PlayField has
     */
    public void randomFood(int rows, int cols) {
        int tempX = 0;
        int tempY = 0;
        // Do not spawn the food on the snake @author the one and ONLY: *************dhain*************.
        do {
            foodX = (int) (Math.random() * rows);
            foodY = (int) (Math.random() * cols);
            for (Corner part : SnakeController.snake) {
                tempX = part.x;
                tempY = part.y;
            }
        } while (foodX == tempX || foodY == tempY);

        foodImage = new Image(new File(foodString[(int) (Math.random() * foodString.length)]).toURI().toString(), 50, 50, false, false);
    }


    /**
     * Getter for the X coordinate of the Food.
     *
     * @return the X coordinate off the Food.
     */
    public int getFoodX() {
        return foodX;
    }

    /**
     * Getter for the Y coordinate of the Food.
     *
     * @return the Y coordinate off the Food.
     */
    public int getFoodY() {
        return foodY;
    }

    /**
     * Getter for the FoodImage
     *
     * @return the foodImage for the Food.
     */
    public Image getFoodImage() {
        return foodImage;
    }
}

