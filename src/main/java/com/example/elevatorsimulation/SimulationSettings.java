package com.example.elevatorsimulation;

import com.example.elevatorsimulation.Elevators.Elevator;
import com.example.elevatorsimulation.Passengers.Passenger;

import java.util.ArrayList;

public class SimulationSettings {
    public int number_of_elevators;
    int number_of_floors;
    public ArrayList<ElevatorInformation> elevatorInformationArrayList = new ArrayList<>();
    public ArrayList<PassengerInformation> passengerInformationArrayList = new ArrayList<>();
    public ArrayList<PassengerRequestPercentage> passenger_request_percentage = new ArrayList<>();
    public ArrayList<ElevatorRequestPercentage> elevator_request_percentage = new ArrayList<>();


    //How many iterations
    public int iterations;


    @Override
    public String toString() {
        String out = "";
        out += number_of_floors;
        out += " " + passengerInformationArrayList.size();
        out += " " + elevatorInformationArrayList.size();
        out += " " + passenger_request_percentage.size();
        out += " " + elevator_request_percentage.size();
        out += " " + number_of_elevators;
        out += " " + iterations;
        return out;
    }

    public int getNumber_of_floors() {
        return number_of_floors;
    }

    public void setNumber_of_floors(int number_of_floors) {
        this.number_of_floors = number_of_floors;
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

    public int getIterations() {
        return iterations;
    }

    public void setIterations(int run_simulation) {
        this.iterations = run_simulation;
    }
}
