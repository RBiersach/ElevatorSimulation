package com.example.elevatorsimulation;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.io.IOException;

public class HelloController {

    @FXML
    private GridPane gridContainer;

    @FXML
    public Label iterationLabel;
    @FXML
    private ScrollPane scrollPane;

    SimulationSettings sm = new SimulationSettings();

    @FXML
    public void initialize() throws IOException {


        FileManipulator fm = new FileManipulator();
        sm = fm.readSettingsInformation("settings.txt");
        System.out.println(sm.toString());


        int BOX_SIZE = 60;
        for (int row = sm.number_of_floors; row > 0; row--) {
            for (int col = 0; col < sm.number_of_elevators; col++) {
                Rectangle rectangle = new Rectangle(BOX_SIZE, 15, Color.WHITE);
                rectangle.setStroke(Color.BLACK);
                gridContainer.add(rectangle, col, row);
            }
        }
    }

    @FXML
    protected void onHelloButtonClick() throws IOException {

        ElevatorSimulation simulation = new ElevatorSimulation(sm);

        int[] loopCounter = {1};
        final int maxIteration = sm.iterations;
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(250), event -> {
            if (loopCounter[0] <= maxIteration) {
                // Perform actions here for each iteration

                //Updates Iteration Counter
                iterationLabel.setText("" + loopCounter[0]);

                //Sets all Grid boxes back to white
                for (int row = 0; row < simulation.building.Floors.size(); row++) {
                    for (int col = 0; col < simulation.building.Elevators.size(); col++) {
                        Rectangle rectangle = (Rectangle) gridContainer.getChildren().get(row * simulation.building.Elevators.size() + col);
                        rectangle.setStroke(Color.BLACK);
                        rectangle.setFill(Color.WHITE);
                    }
                }
                //Sets the selected Grid boxes to corresponding color of elevators
                for (int i = 0; i < simulation.building.Elevators.size(); i++) {
                    int selectedRow = simulation.building.Elevators.get(i).getCurrentFloor();
                    //int selectedRow = (int) (Math.random() * 30);
                    int selectedCol = i;
                    Rectangle elevatorRectangle = (Rectangle) gridContainer.getChildren().get(selectedRow * simulation.building.Elevators.size() + selectedCol);
                    if (simulation.building.Elevators.get(i).elevatorType.equals("StandardElevator")) {
                        elevatorRectangle.setFill(Color.GREEN);
                    } else if (simulation.building.Elevators.get(i).elevatorType.equals("ExpressElevator")) {
                        elevatorRectangle.setFill(Color.BLUE);
                    } else if (simulation.building.Elevators.get(i).elevatorType.equals("FreightElevator")) {
                        elevatorRectangle.setFill(Color.RED);
                    } else if (simulation.building.Elevators.get(i).elevatorType.equals("GlassElevator")) {
                        elevatorRectangle.setFill(Color.YELLOW);
                    } else {
                        elevatorRectangle.setFill(Color.ORANGE);
                    }
                }
                //Calls Scan method
                simulation.building.scanFloors();
                //Updates iteration counter
                loopCounter[0]++;
            } else {
                //Once iteration count = max iterations, break out of loop
                timeline.stop();
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
}





