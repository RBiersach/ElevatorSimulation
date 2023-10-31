module com.example.elevatorsimulation {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.elevatorsimulation to javafx.fxml;
    exports com.example.elevatorsimulation;
    exports com.example.elevatorsimulation.Elevators;
    opens com.example.elevatorsimulation.Elevators to javafx.fxml;
    exports com.example.elevatorsimulation.Passengers;
    opens com.example.elevatorsimulation.Passengers to javafx.fxml;
}