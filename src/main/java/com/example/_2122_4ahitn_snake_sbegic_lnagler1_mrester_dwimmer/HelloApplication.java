package com.example._2122_4ahitn_snake_sbegic_lnagler1_mrester_dwimmer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private static Scene scene;

    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("menue-view"), 640, 650);
        stage.setScene(scene);
        stage.setTitle("Snake");
        stage.show();

    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    static void loadStageFromRoot(StackPane root, String stageName){
        Stage stage = new Stage();
        Scene scene1 = new Scene(root);
        stage.setTitle(stageName);
        stage.setScene(scene1);
        stage.show();
    }

    public static void main(String[] args) {
        launch();

    }
}