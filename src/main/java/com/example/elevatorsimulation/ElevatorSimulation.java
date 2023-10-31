package com.example.elevatorsimulation;

public class ElevatorSimulation {
    SimulationSettings _simulationSettings = new SimulationSettings();
    public boolean initSimulaton(String fileName){
        _simulationSettings = readSettingsContent(fileName);
        return true;
    }
    private SimulationSettings readSettingsContent(String fileName){
        SimulationSettings _currentSettings = new SimulationSettings();
        //Read Information from file. Please use the FileMani provided in the previous Class.
        return _currentSettings;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
