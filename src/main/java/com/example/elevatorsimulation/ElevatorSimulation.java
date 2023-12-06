package com.example.elevatorsimulation;

public class ElevatorSimulation {
    SimulationSettings sm;
    Building building;

    public ElevatorSimulation(SimulationSettings _sm) {
        this.sm = _sm;
        this.building = new Building(_sm);
    }

    public boolean initSimulaton() {
//        for (int i = 0; i < building.Passengers.size(); i++) {
//            for (int j = 0; j < building.Floors.size(); j++) {
//                if (building.Passengers.get(i).getStartingFloor() == building.Floors.get(j).floorID) {
//                    building.Floors.get(j).waitQueue.add(building.Passengers.get(i));
//                }
//            }
//        }
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
