package com.example.elevatorsimulation;

import com.example.elevatorsimulation.Elevators.*;
import com.example.elevatorsimulation.Passengers.*;

import java.util.ArrayList;

public class Building {
    ArrayList<Floor> Floors = new ArrayList<>();
    ArrayList<Elevator> Elevators = new ArrayList<>();
    ArrayList<Passenger> Passengers = new ArrayList<>();
    SimulationSettings sm = new SimulationSettings();
    ArrayList<Passenger> standardWaitQueue = new ArrayList<>();
    ArrayList<Passenger> expressWaitQueue = new ArrayList<>();
    ArrayList<Passenger> freightWaitQueue = new ArrayList<>();
    ArrayList<Passenger> glassWaitQueue = new ArrayList<>();
    ArrayList<Passenger> completedQueue = new ArrayList<>();

    public boolean scanFloors() {
//        for (int i = 0; i < Floors.size(); i++) {
//            Floors.get(i).loadAndUnload();
//        }
        for (int i = 0; i < Elevators.size(); i++) {
            if (Elevators.get(i).passengers.isEmpty()) {
                if ((!standardWaitQueue.isEmpty()) && Elevators.get(i).elevatorType.equals("StandardElevator")) {
                    if (standardWaitQueue.get(0).getStartingFloor() > Elevators.get(i).currentFloor) {
                        Elevators.get(i)._direction = (direction.UP);

                    } else if (standardWaitQueue.get(0).getStartingFloor() < Elevators.get(i).currentFloor) {
                        Elevators.get(i)._direction = (direction.DOWN);

                    } else if (standardWaitQueue.get(0).getStartingFloor() == Elevators.get(i).currentFloor) {
                        Elevators.get(i).passengers.add(standardWaitQueue.get(0));
                        standardWaitQueue.remove(0);
                        Elevators.get(i)._direction = (direction.IDLE);
                        System.out.println("Elevator: " + (i + 1) + " picked up passenger on floor: " + Elevators.get(i).currentFloor);
                    }
                }
                if ((!expressWaitQueue.isEmpty()) && Elevators.get(i).elevatorType.equals("ExpressElevator")) {
                    if (expressWaitQueue.get(0).getStartingFloor() > Elevators.get(i).currentFloor) {
                        Elevators.get(i)._direction = (direction.UP);

                    } else if (expressWaitQueue.get(0).getStartingFloor() < Elevators.get(i).currentFloor) {
                        Elevators.get(i)._direction = (direction.DOWN);

                    } else if (expressWaitQueue.get(0).getStartingFloor() == Elevators.get(i).currentFloor) {
                        Elevators.get(i).passengers.add(expressWaitQueue.get(0));
                        expressWaitQueue.remove(0);
                        Elevators.get(i)._direction = (direction.IDLE);
                        System.out.println("Elevator: " + (i + 1) + " picked up passenger on floor: " + Elevators.get(i).currentFloor);

                    }
                }
                if ((!freightWaitQueue.isEmpty()) && Elevators.get(i).elevatorType.equals("FreightElevator")) {
                    if (freightWaitQueue.get(0).getStartingFloor() > Elevators.get(i).currentFloor) {
                        Elevators.get(i)._direction = (direction.UP);

                    } else if (freightWaitQueue.get(0).getStartingFloor() < Elevators.get(i).currentFloor) {
                        Elevators.get(i)._direction = (direction.DOWN);

                    } else if (freightWaitQueue.get(0).getStartingFloor() == Elevators.get(i).currentFloor) {
                        Elevators.get(i).passengers.add(freightWaitQueue.get(0));
                        freightWaitQueue.remove(0);
                        Elevators.get(i)._direction = (direction.IDLE);
                        System.out.println("Elevator: " + (i + 1) + " picked up passenger on floor: " + Elevators.get(i).currentFloor);

                    }
                }
                if ((!glassWaitQueue.isEmpty()) && Elevators.get(i).elevatorType.equals("GlassElevator")) {
                    if (glassWaitQueue.get(0).getStartingFloor() > Elevators.get(i).currentFloor) {
                        Elevators.get(i)._direction = (direction.UP);

                    } else if (glassWaitQueue.get(0).getStartingFloor() < Elevators.get(i).currentFloor) {
                        Elevators.get(i)._direction = direction.DOWN;

                    } else if (glassWaitQueue.get(0).getStartingFloor() == Elevators.get(i).currentFloor) {
                        Elevators.get(i).passengers.add(glassWaitQueue.get(0));
                        glassWaitQueue.remove(0);
                        Elevators.get(i)._direction = direction.IDLE;
                        System.out.println("Elevator: " + (i + 1) + " picked up passenger on floor: " + Elevators.get(i).currentFloor);

                    }
                }
            } else {
                if (Elevators.get(i).passengers.get(0).destinationFloor > Elevators.get(i).getCurrentFloor()) {
                    Elevators.get(i)._direction = (direction.UP);

                } else if (Elevators.get(i).passengers.get(0).destinationFloor < Elevators.get(i).getCurrentFloor()) {
                    Elevators.get(i)._direction = (direction.DOWN);

                } else if (Elevators.get(i).passengers.get(0).destinationFloor == Elevators.get(i).getCurrentFloor()) {
                    completedQueue.add(Elevators.get(i).passengers.get(0));
                    Elevators.get(i).passengers.remove(0);
                    Elevators.get(i)._direction = (direction.IDLE);
                    System.out.println("Elevator: " + (i + 1) + " Dropped off passenger on floor: " + Elevators.get(i).currentFloor);


                }
            }
            Elevators.get(i).move(sm);
        }
        return true;
    }

    public Building(SimulationSettings _sm) {
        this.sm = _sm;
        for (int i = 0; i < _sm.getNumber_of_floors(); i++) {
            Floor floor = new Floor(i, _sm);
            Floors.add(floor);
        }

        for (int i = 0; i < _sm.elevatorInformationArrayList.size(); i++) {


            Double requestsAsPercentage = (_sm.elevatorInformationArrayList.get(i).elevatorRequestPercentage) * 0.01;
            int numToAdd = (int) Math.round(requestsAsPercentage * _sm.number_of_elevators);


            if (_sm.elevatorInformationArrayList.get(i).elevatorType.equals("StandardElevator")) {
                for (int j = 0; j < numToAdd; j++) {
                    Elevator elevator = new StandardElevator();
                    elevator.elevatorType = _sm.elevatorInformationArrayList.get(i).elevatorType;
                    elevator.maximumCapacity = _sm.elevatorInformationArrayList.get(i).maximumCapacity;
                    elevator.elevatorRequestPercentage = _sm.elevatorInformationArrayList.get(i).elevatorRequestPercentage;
                    elevator._direction = direction.IDLE;
                    elevator.currentFloor = 0;
                    Elevators.add(elevator);
                }
            } else if (_sm.elevatorInformationArrayList.get(i).elevatorType.equals("ExpressElevator")) {
                for (int j = 0; j < numToAdd; j++) {
                    Elevator elevator = new ExpressElevator();
                    elevator.elevatorType = _sm.elevatorInformationArrayList.get(i).elevatorType;
                    elevator.maximumCapacity = _sm.elevatorInformationArrayList.get(i).maximumCapacity;
                    elevator.elevatorRequestPercentage = _sm.elevatorInformationArrayList.get(i).elevatorRequestPercentage;
                    elevator._direction = direction.IDLE;
                    elevator.currentFloor = 0;
                    Elevators.add(elevator);
                }
            } else if (_sm.elevatorInformationArrayList.get(i).elevatorType.equals("FreightElevator")) {
                for (int j = 0; j < numToAdd; j++) {
                    Elevator elevator = new FreightElevator();
                    elevator.elevatorType = _sm.elevatorInformationArrayList.get(i).elevatorType;
                    elevator.maximumCapacity = _sm.elevatorInformationArrayList.get(i).maximumCapacity;
                    elevator.elevatorRequestPercentage = _sm.elevatorInformationArrayList.get(i).elevatorRequestPercentage;
                    elevator._direction = direction.IDLE;
                    elevator.currentFloor = 0;
                    Elevators.add(elevator);
                }
            } else if (_sm.elevatorInformationArrayList.get(i).elevatorType.equals("GlassElevator")) {
                for (int j = 0; j < numToAdd; j++) {
                    Elevator elevator = new GlassElevator();
                    elevator.elevatorType = _sm.elevatorInformationArrayList.get(i).elevatorType;
                    elevator.maximumCapacity = _sm.elevatorInformationArrayList.get(i).maximumCapacity;
                    elevator.elevatorRequestPercentage = _sm.elevatorInformationArrayList.get(i).elevatorRequestPercentage;
                    elevator._direction = direction.IDLE;
                    elevator.currentFloor = 0;
                    Elevators.add(elevator);
                }
            }
        }
        for (int i = 0; i < _sm.passengerInformationArrayList.size(); i++) {
            if (_sm.passengerInformationArrayList.get(i).typeOfPassenger.equals("Standard")) {
                Passenger passenger = new StandardPassenger();
                passenger.startingFloor = _sm.passengerInformationArrayList.get(i).startingFloor;
                passenger.destinationFloor = _sm.passengerInformationArrayList.get(i).destinationFloor;
                passenger.passengerType = _sm.passengerInformationArrayList.get(i).typeOfPassenger;
                passenger.passengerRequestPercentage = _sm.passengerInformationArrayList.get(i).passengerRequestPercentage;
                Passengers.add(passenger);
                standardWaitQueue.add(passenger);
            } else if (_sm.passengerInformationArrayList.get(i).typeOfPassenger.equals("VIP")) {
                Passenger passenger = new VipPassenger();
                passenger.startingFloor = _sm.passengerInformationArrayList.get(i).startingFloor;
                passenger.destinationFloor = _sm.passengerInformationArrayList.get(i).destinationFloor;
                passenger.passengerType = _sm.passengerInformationArrayList.get(i).typeOfPassenger;
                passenger.passengerRequestPercentage = _sm.passengerInformationArrayList.get(i).passengerRequestPercentage;
                Passengers.add(passenger);
                expressWaitQueue.add(passenger);
            } else if (_sm.passengerInformationArrayList.get(i).typeOfPassenger.equals("Freight")) {
                Passenger passenger = new FreightPassenger();
                passenger.startingFloor = _sm.passengerInformationArrayList.get(i).startingFloor;
                passenger.destinationFloor = _sm.passengerInformationArrayList.get(i).destinationFloor;
                passenger.passengerType = _sm.passengerInformationArrayList.get(i).typeOfPassenger;
                passenger.passengerRequestPercentage = _sm.passengerInformationArrayList.get(i).passengerRequestPercentage;
                Passengers.add(passenger);
                freightWaitQueue.add(passenger);
            } else if (_sm.passengerInformationArrayList.get(i).typeOfPassenger.equals("Glass")) {
                Passenger passenger = new GlassPassenger();
                passenger.startingFloor = _sm.passengerInformationArrayList.get(i).startingFloor;
                passenger.destinationFloor = _sm.passengerInformationArrayList.get(i).destinationFloor;
                passenger.passengerType = _sm.passengerInformationArrayList.get(i).typeOfPassenger;
                passenger.passengerRequestPercentage = _sm.passengerInformationArrayList.get(i).passengerRequestPercentage;
                Passengers.add(passenger);
                glassWaitQueue.add(passenger);
            }
        }
    }

}
