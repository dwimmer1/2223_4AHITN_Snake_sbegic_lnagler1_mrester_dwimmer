package com.example._2122_4ahitn_snake_sbegic_lnagler1_mrester_dwimmer;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Food {
    private final String foodString = "assets/icon/ic_apple.png";
    private static int foodX;
    private static int foodY;
    private Image foodImage;

    public void randomFood(int rows, int cols){
        foodX = (int) (Math.random() * rows);
        foodY = (int) (Math.random() * cols);
        foodImage = new Image("https://i.pinimg.com/originals/58/25/d5/5825d50c11a14cce6e80239de736d3c7.png", 50, 50, false, false);
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
