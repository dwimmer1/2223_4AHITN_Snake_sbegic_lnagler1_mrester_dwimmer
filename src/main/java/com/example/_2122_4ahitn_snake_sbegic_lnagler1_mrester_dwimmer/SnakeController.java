package com.example._2122_4ahitn_snake_sbegic_lnagler1_mrester_dwimmer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class SnakeController extends Application {
    // variable
    int saveSp = 0;
    static int ghost = 0;
    static int speed = 4;
    static int maxSpeed;
    static String difficulty;
    static int score = 0;
    static int count = 0;
    static Food food = new Food();
    static Playfield playfield = new Playfield();
    static PlayFieldController playFieldController = new PlayFieldController();
    static int foodcolor = 0;

    static int width = 20;
    static int height = 20;
    static int cornersize = 25;
    static int startSize = 4;
    static List<Corner> snake = new ArrayList<>();
    static Dir direction = Dir.left;
    static boolean gameOver = false;
    static Image img = (new Image(new File("assets/icon/mario.png").toURI().toString()));

    // Enum für gespeicherte mögliche direction
    /**
     * @author: dwimmer1
     * dir
     * Dient als enum zur zwischenspeicherung der directions
     *
     * @param
     * @return 	noned
     */
    public enum Dir {
        left, right, up, down,
    }



    public static void setSpeed(String diff) {
        difficulty = diff;

        if (difficulty.equals("Normal")) {
            speed = 6;
        }
        if (difficulty.equals("Schwer")) {
            speed = 8;
        }
        if (difficulty.equals("0/10Yasuo")) {
            speed = 10;
        }
        maxSpeed = speed + 3;
    }

    public void start(Stage primaryStage) {
        try {
            newFood();


            VBox root = new VBox();
            Canvas c = new Canvas(width * cornersize, height * cornersize);
            GraphicsContext gc = c.getGraphicsContext2D();
            root.getChildren().add(c);



            new AnimationTimer() {
                long lastTick = 0;
                /**
                 * @author: dwimmer1, lnalger
                 * handle
                 * ist grundlegende handle function für die tick function eventfilter für keyinputs
                 *
                 * @param now
                 * @return 	noned
                 */
                public void handle(long now) {
                    if (lastTick == 0) {
                        lastTick = now;
                        tick(gc);
                        return;
                    }
                    if (speed != 0) {
                        if (now - lastTick > 1000000000 / speed) {
                            lastTick = now;
                            tick(gc);
                        }
                    }

                }

            }.start();

            Scene scene = new Scene(root, width * cornersize, height * cornersize);

            // control
            scene.addEventFilter(KeyEvent.KEY_PRESSED, key -> {
                if ((key.getCode() == KeyCode.UP || key.getCode() == KeyCode.W) && direction != Dir.down) {
                    direction = Dir.up;
                }
                if ((key.getCode() == KeyCode.LEFT || key.getCode() == KeyCode.A) && direction != Dir.right) {
                    direction = Dir.left;
                }
                if ((key.getCode() == KeyCode.DOWN || key.getCode() == KeyCode.S) && direction != Dir.up) {
                    direction = Dir.down;
                }
                if ((key.getCode() == KeyCode.RIGHT || key.getCode() == KeyCode.D) && direction != Dir.left) {
                    direction = Dir.right;
                }
                if (key.getCode() == KeyCode.SPACE) {
                    //when the spacebar is pressed the snake pauses
                    if(speed >0){
                        saveSp = speed;
                        speed = 0;
                    }else if (speed ==0){
                        speed = saveSp;
                    }
                }
                if (key.getCode() == KeyCode.R) {
                    //when the R Key is pressed the game resets. Snake in middle and Points to 0
                    gameOver = false;
                    snake.clear();
                    score = 0;
                    for(int i = 0; i < startSize; i++){
                        snake.add(new Corner(width / 2, height / 2));
                    }
                    primaryStage.close();
                    primaryStage.setScene(scene);
                    primaryStage.setTitle("SNAKE");
                    primaryStage.show();
                }
                if (key.getCode() == KeyCode.ESCAPE){
                    //closes the game
                    primaryStage.close();
                }

            });

            // add start snake parts
            for(int i = 0; i < startSize; i++){
                snake.add(new Corner(width / 2, height / 2));
            }

            //sets the scene
            primaryStage.setScene(scene);
            primaryStage.setTitle("SNAKE");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @author: dwimmer1
     * tick
     * animation tick timer in ihr wird LooseCondition und directions geprüft
     *
     * @param gc
     * @return 	noned
     */
    public static void tick(GraphicsContext gc) {

        if (gameOver) {
            gc.setFill(Color.RED);
            gc.setFont(new Font("", 50));
            gc.fillText("GAME OVER", 100, 250);
            return;
        }
        for (int i = snake.size() - 1; i >= 1; i--) {
            snake.get(i).x = snake.get(i - 1).x;
            snake.get(i).y = snake.get(i - 1).y;
        }

        switch (direction) {
            case up:
                snake.get(0).y--;
                if (snake.get(0).y < 0) {
                    gameOver = true;
                }
                break;
            case down:
                snake.get(0).y++;
                if (snake.get(0).y > height - 1) {
                    gameOver = true;
                }
                break;
            case left:
                snake.get(0).x--;
                if (snake.get(0).x < 0) {
                    gameOver = true;
                }
                break;
            case right:
                snake.get(0).x++;
                if (snake.get(0).x > width - 1) {
                    gameOver = true;
                }
                break;

        }

        // eat
        if (food.getFoodX() == snake.get(1).x && food.getFoodY() == snake.get(1).y) {
            snake.add(new Corner(-1, -1));
            score++;
            newFood();
        }


        for (int i = 1; i < snake.size(); i++) {
            if (snake.get(0).x == snake.get(i).x && snake.get(0).y == snake.get(i).y) {
                gameOver = true;
            }
        }


        // fill
        // background
        playfield.drawBackground(width, height, gc, cornersize);
        // Füllt wieder den hintergrund hinter der Schlange

        // score
        gc.setFill(Color.BLACK);
        gc.setFont(new Font("", 15));
        gc.fillText("Punkte: " + (score), 10, 30);
        //Speed benutz da die variable immer mitgecountet wird

        // snake
        for (Corner c : snake) {
            if (ghost == 0) {
                gc.setFill(Color.TRANSPARENT);
                ghost++;
            } else if (ghost == 1) {
                gc.drawImage(img, c.x * cornersize, c.y * cornersize, cornersize - 2, cornersize - 2);
                ghost++;
            } else {
                gc.setFill(Color.GREEN);
            }


            gc.fillRect(c.x * cornersize, c.y * cornersize, cornersize - 2, cornersize - 2);
        }
        ghost = 0;

        playfield.drawFood(gc, cornersize, food);
    }

    // food
    public static void newFood() {
        food.randomFood(width, height);
        count++;
        if (speed != maxSpeed) {
            if (count % 4 == 0) {
                speed++;
            }


        }


    }

    public static void main(String[] args) {
        launch(args);
    }
}
