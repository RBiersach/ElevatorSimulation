package com.example.elevatorsimulation;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SimulationSettings {
    int floors;
    public ArrayList<AddPassenger> add_passenger = new ArrayList<>();
    public ArrayList<AddElevator> add_elevator = new ArrayList<>();
    public ArrayList<PassengerRequestPercentage> passenger_request_percentage = new ArrayList<>();
    public ArrayList<ElevatorRequestPercentage> elevator_request_percentage = new ArrayList<>();

    public int number_of_elevators;

    //How many iterations
    public int run_simulation;

    @Override
    public String toString() {
        String out = "";
        out += floors;
        out += " " + add_passenger.size();
        out += " " + add_elevator.size();
        out += " " + passenger_request_percentage.size();
        out += " " + elevator_request_percentage.size();
        out += " " + number_of_elevators;
        out += " " + run_simulation;
        return out;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public ArrayList<AddPassenger> getAdd_passenger() {
        return add_passenger;
    }

    public void setAdd_passenger(ArrayList<AddPassenger> add_passenger) {
        this.add_passenger = add_passenger;
    }

    public ArrayList<AddElevator> getAdd_elevator() {
        return add_elevator;
    }

    public void setAdd_elevator(ArrayList<AddElevator> add_elevator) {
        this.add_elevator = add_elevator;
    }

    public ArrayList<PassengerRequestPercentage> getPassenger_request_percentage() {
        return passenger_request_percentage;
    }

    public void setPassenger_request_percentage(ArrayList<PassengerRequestPercentage> passenger_request_percentage) {
        this.passenger_request_percentage = passenger_request_percentage;
    }

    public ArrayList<ElevatorRequestPercentage> getElevator_request_percentage() {
        return elevator_request_percentage;
    }

    public void setElevator_request_percentage(ArrayList<ElevatorRequestPercentage> elevator_request_percentage) {
        this.elevator_request_percentage = elevator_request_percentage;
    }

    public int getNumber_of_elevators() {
        return number_of_elevators;
    }

    public void setNumber_of_elevators(int number_of_elevators) {
        this.number_of_elevators = number_of_elevators;
    }

    public int getRun_simulation() {
        return run_simulation;
    }

    public void setRun_simulation(int run_simulation) {
        this.run_simulation = run_simulation;
    }
}
