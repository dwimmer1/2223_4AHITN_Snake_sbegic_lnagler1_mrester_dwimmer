package com.example._2122_4ahitn_snake_sbegic_lnagler1_mrester_dwimmer;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.io.File;
import java.util.Random;

public class Food {
    private final String foodString[] = {"assets/icon/MciResize.png", "assets/icon/apple.png"};
    private static int foodX;
    private static int foodY;
    private Image foodImage;

    public void randomFood(int rows, int cols) {
        int tempX = 0;
        int tempY = 0;
        // Do not spawn the food on the snake @author the one and ONLY: *************dhain*************.
        do {
            foodX = (int) (Math.random() * rows);
            foodY = (int) (Math.random() * cols);
            for (SnakeController.Corner part : SnakeController.snake) {
                tempX = part.x;
                tempY = part.y;
            }
        } while (foodX == tempX || foodY == tempY);

        foodImage = new Image(new File(foodString[(int) (Math.random() * foodString.length)]).toURI().toString(), 50, 50, false, false);
    }


    public int getFoodX() {
        return foodX;
    }

    public int getFoodY() {
        return foodY;
    }

    public Image getFoodImage() {
        return foodImage;
    }
}
