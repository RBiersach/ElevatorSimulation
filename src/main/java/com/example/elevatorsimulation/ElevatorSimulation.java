package com.example.elevatorsimulation;

public class ElevatorSimulation {
    SimulationSettings simulationSettings = new SimulationSettings();

    public boolean initSimulaton(SimulationSettings _simulationSettings) {
        this.simulationSettings = _simulationSettings;
        return true;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
