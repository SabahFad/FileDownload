// Student Name : Sabah Fadaous
// Student ID   : 220222361
// Course       : Programming III Lab - CSCI 2108
// Instructor   : Aya N. Alharazin

package com.download;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class MainController {

    @FXML private ProgressBar progressBar1;
    @FXML private Label statusLabel1;
    @FXML private Label percentLabel1;

    @FXML private ProgressBar progressBar2;
    @FXML private Label statusLabel2;
    @FXML private Label percentLabel2;

    @FXML private ProgressBar progressBar3;
    @FXML private Label statusLabel3;
    @FXML private Label percentLabel3;

    @FXML private Button startButton;
    @FXML private Button resetButton;

    @FXML
    public void initialize() {
        clearAll();
    }

    @FXML
    private void handleStart() {
        startButton.setDisable(true);
        resetButton.setDisable(false);

        Thread t1 = new Thread(new DownloadTask(progressBar1, statusLabel1, percentLabel1, 40));
        Thread t2 = new Thread(new DownloadTask(progressBar2, statusLabel2, percentLabel2, 70));
        Thread t3 = new Thread(new DownloadTask(progressBar3, statusLabel3, percentLabel3, 25));

        t1.setDaemon(true);
        t2.setDaemon(true);
        t3.setDaemon(true);

        t1.start();
        t2.start();
        t3.start();
    }

    @FXML
    private void handleReset() {
        clearAll();
    }

    private void clearAll() {
        progressBar1.setProgress(0);
        progressBar2.setProgress(0);
        progressBar3.setProgress(0);

        percentLabel1.setText("0%");
        percentLabel2.setText("0%");
        percentLabel3.setText("0%");

        statusLabel1.setText("Waiting...");
        statusLabel2.setText("Waiting...");
        statusLabel3.setText("Waiting...");

        for (Label lbl : new Label[]{statusLabel1, statusLabel2, statusLabel3}) {
            lbl.getStyleClass().removeAll("status-downloading", "status-done");
            lbl.getStyleClass().add("status-idle");
        }

        startButton.setDisable(false);
        resetButton.setDisable(true);
    }
}
