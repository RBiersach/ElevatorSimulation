package com.example.elevatorsimulation;

public class ElevatorSimulation {
    SimulationSettings sm;
    Building building;

    public ElevatorSimulation(SimulationSettings _sm) {
        this.sm = _sm;
        this.building = new Building(_sm);
    }

    public boolean initSimulaton() {
        return true;
    }

    public boolean runSimulation() {
        building.scanFloors();
        return true;
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
