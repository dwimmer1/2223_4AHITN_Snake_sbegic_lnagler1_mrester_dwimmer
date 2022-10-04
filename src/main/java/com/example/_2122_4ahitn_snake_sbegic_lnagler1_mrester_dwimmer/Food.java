package com.example._2122_4ahitn_snake_sbegic_lnagler1_mrester_dwimmer;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.io.File;

public class Food {
    private final String foodString[] = {"assets/icon/MciResize.png", "assets/icon/apple.png"};
    private static int foodX;
    private static int foodY;
    private Image foodImage;

    public void randomFood(int rows, int cols){
        foodX = (int) (Math.random() * rows);
        foodY = (int) (Math.random() * cols);
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
