package com.example._2122_4ahitn_snake_sbegic_lnagler1_mrester_dwimmer;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Snake {

    public static final Color aliveSnakeColor = Color.BLACK;
    public static final Color deadSnakeColor = Color.RED;
    public int snakelenght = 0;
    public int xVelocity;
    public int yVelocity;





    public void SnakeInit(){
        snakelenght = 1;
        xVelocity = 1;
        yVelocity = 1;

    }



    /**
     * SnakeExpander
     * Dient dazu wenn ein essen gegessen wurde wird der body um jeweils einen Part erweitert
     *
     * @param
     * @return 	noned
     */
    public void SnakeExpander(){

        snakelenght++;
        checkLenght();
    }

    private void checkLenght() {
    }

    public void setDifficulty(String difficulty){

    }

    public void chooselevel(int level){
        if (level == 0){ // 0 == leicht
            xVelocity = 1;
            yVelocity = 1;
        }else if (level == 1){ // == mittel
            xVelocity = 3;
            yVelocity = 3;
        } else if (level == 2 ){
            xVelocity = 5;
            yVelocity = 5;
        }


    }


}

