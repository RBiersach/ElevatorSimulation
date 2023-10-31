package com.example.elevatorsimulation;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import java.util.Scanner;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            ElevatorSimulation _simulation = new ElevatorSimulation();
            _simulation.initSimulaton(selectedFile.getAbsolutePath());


        }
    }
}