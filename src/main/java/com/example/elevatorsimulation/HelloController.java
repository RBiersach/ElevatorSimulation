package com.example.elevatorsimulation;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.IOException;

public class HelloController {

    @FXML
    private GridPane gridContainer;

    @FXML
    protected void onHelloButtonClick() throws IOException {

        int column = 0;
        int row = 1;

        SimulationSettings sm = new SimulationSettings();

        FileManipulator fm = new FileManipulator();
        sm = fm.readSettingsInformation("settings.txt");
        System.out.println(sm.toString());


        ElevatorSimulation simulation = new ElevatorSimulation();
        simulation.initSimulaton(sm);
        simulation.runSimulation(sm);

        int count = 0;
        for (int j = 0; j < sm.floors; j++) {
            for (int i = 0; i < sm.number_of_elevators; i++) {
                gridContainer.add(new Text(count + "  "), i, j);
                count++;

            }

        }

    }
}
