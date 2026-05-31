// Student Name : Sabah Fadaous
// Student ID   : 220222361
// Course       : Programming III Lab - CSCI 2108
// Instructor   : Aya N. Alharazin

package com.download;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/download/main.fxml"));
        Scene scene = new Scene(loader.load());
        scene.getStylesheets().add(getClass().getResource("/com/download/styles.css").toExternalForm());
        primaryStage.setTitle("File Download Simulator");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
