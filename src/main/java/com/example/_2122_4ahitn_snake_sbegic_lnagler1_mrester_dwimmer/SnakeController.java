package com.example._2122_4ahitn_snake_sbegic_lnagler1_mrester_dwimmer;

import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;

public class SnakeController extends Application {

    Snake snake = new Snake();

    public static void main(String[] args) {

    }

    @Override
    public void start(Stage stage) throws Exception {
        new Thread();
        Canvas canvas = new Canvas(500, 500);
        canvas.setOnKeyPressed(e -> {

            /*
            switch (e.getCode()) {
                case UP:
                    snake.setUp();
                    break;
                case DOWN:
                    snake.setDown();
                    break;
                case LEFT:
                    snake.setLeft();
                    break;
                case RIGHT:
                    snake.setRight();
                    break;
                case ENTER:
                    if (loop.isPaused()) {
                        reset();
                        (new Thread(loop)).start();
                    }
        }


             */
                    });



}
}