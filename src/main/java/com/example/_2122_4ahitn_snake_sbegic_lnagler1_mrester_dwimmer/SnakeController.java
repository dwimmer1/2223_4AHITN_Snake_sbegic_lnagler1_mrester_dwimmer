package com.example._2122_4ahitn_snake_sbegic_lnagler1_mrester_dwimmer;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class SnakeController extends Application {

    Snake snake = new Snake();
    int speedTest = 5;
    static int widht = 20;
    static int height = 20;
    static boolean gameOver = false;
    public static List<Corner> snakeList = new ArrayList<>();
    public static Dir direction = Dir.left;

    public enum Dir {
        left, right, up, down
    }


    @Override
    public void start(Stage stage) throws Exception {
        new Thread();
        VBox root = new VBox();
        Canvas canvas = new Canvas(500, 500);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);


        new AnimationTimer() {
            long lastTick = 0;

            @Override
            public void handle(long l) {
                if (lastTick == 0) {
                    lastTick = l;

                    return;
                }
                if (l - lastTick > 1000000 / speedTest) { // Ticks pro frame
                    lastTick = l;
                }
            }

        }.start();
        Scene scene = new Scene(root, 20, 20);
        scene.addEventFilter(KeyEvent.KEY_PRESSED, key -> {
            if (key.getCode() == KeyCode.W) {
                direction = Dir.up;
            }
            if (key.getCode() == KeyCode.A) {
                direction = Dir.left;
            }
            if (key.getCode() == KeyCode.S) {
                direction = Dir.down;
            }
            if (key.getCode() == KeyCode.D) {
                direction = Dir.right;
            }
        });
        //Starter snake Part
        snakeList.add(new Corner(widht / 2, height / 2));
        snakeList.add(new Corner(widht / 2, height / 2));
        snakeList.add(new Corner(widht / 2, height / 2));
    }

    public static void tick(GraphicsContext gc) {
        if (gameOver) {
            // game over condition
            return;
        }
        for (int i = snakeList.size() - 1; i >= 1; i--) {
            snakeList.get(i).x = snakeList.get(i - 1).x;
            snakeList.get(i).y = snakeList.get(i - 1).y;

        }
        switch (direction){  // if border touched
            case up:
                snakeList.get(0).y--;
                if (snakeList.get(0).y > height){
                    gameOver = true;
                }
            case down:
                snakeList.get(0).y++;
                if (snakeList.get(0).y < 0){
                    gameOver = true;
                }
            case left:
                snakeList.get(0).x--;
                if (snakeList.get(0).x < 0){
                    gameOver = true;
                }
            case right:
                snakeList.get(0).x++;
                if (snakeList.get(0).x > widht){
                    gameOver = true;
                }
        }

    }


}