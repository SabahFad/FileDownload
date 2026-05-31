// Student Name : Sabah Fadaous
// Student ID   : 220222361
// Course       : Programming III Lab - CSCI 2108
// Instructor   : Aya N. Alharazin

package com.download;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class DownloadTask implements Runnable {

    private ProgressBar bar;
    private Label statusLbl;
    private Label pctLbl;
    private int delay;

    public DownloadTask(ProgressBar bar, Label statusLbl, Label pctLbl, int delay) {
        this.bar = bar;
        this.statusLbl = statusLbl;
        this.pctLbl = pctLbl;
        this.delay = delay;
    }

    @Override
    public void run() {

        Platform.runLater(() -> {
            statusLbl.setText("Downloading...");
            statusLbl.getStyleClass().removeAll("status-done", "status-idle");
            statusLbl.getStyleClass().add("status-downloading");
        });

        for (int i = 0; i <= 100; i++) {
            double val = i / 100.0;
            int pct = i;

            Platform.runLater(() -> {
                bar.setProgress(val);
                pctLbl.setText(pct + "%");
            });

            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        Platform.runLater(() -> {
            statusLbl.setText("Done ✔");
            statusLbl.getStyleClass().removeAll("status-downloading", "status-idle");
            statusLbl.getStyleClass().add("status-done");
        });
    }
}
