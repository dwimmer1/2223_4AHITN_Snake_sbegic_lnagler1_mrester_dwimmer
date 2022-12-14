package com.example._2122_4ahitn_snake_sbegic_lnagler1_mrester_dwimmer;

import javafx.application.Preloader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;

public class PlayFieldController {


    private final int rows = 20;
    private final int columns = rows;
    private final int width = 600;
    private final int squareSize = width / rows;
    private final int heigth = width;

    private GraphicsContext graphicsContext;
    public VBox VBoxPlay;
    Stage primaryStage = new Stage();
    Food food = new Food();
    private static Scene scene;


    /**
     * @author lnagler1
     */
    public void loadPlayField() {

        primaryStage.setTitle("Snake");
        Group root = new Group();
        Canvas canvas = new Canvas(width, heigth);
        root.getChildren().add(canvas);
        scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        graphicsContext = canvas.getGraphicsContext2D();
        food.randomFood(rows, columns);

        start();

        System.out.println("Bin drin");
    }

    /**
     * Starts the whole Process of creating the PlayField and starting the snake.
     */
    private void start(){
        Playfield playfield = new Playfield();
        playfield.drawBackground(columns, rows, graphicsContext, squareSize);
        playfield.drawFood(graphicsContext, squareSize, food);
        SnakeController snake = new SnakeController();
        snake.start(primaryStage);
    }

    public Scene getScene(){
        return scene;
    }

}
