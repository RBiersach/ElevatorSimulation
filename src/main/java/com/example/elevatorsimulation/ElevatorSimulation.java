package com.example.elevatorsimulation;

import java.util.Random;

public class ElevatorSimulation {
    SimulationSettings sm = new SimulationSettings();

    public boolean initSimulaton(SimulationSettings _sm) {
        this.sm = _sm;
        return true;
    }

    public boolean runSimulation(SimulationSettings _sm) {
        Random r = new Random();
        int r1 = r.nextInt(0, 100);
        int sum = 0;
        // for (int i = 0; i < _sm.passenger_request_percentage.size(); i++)
        {
            if (r1 >= sum && r1 < sum + _sm.passenger_request_percentage.get(0).percentage) {

            }
            sum += _sm.passenger_request_percentage.get(0).percentage;
            if (r1 >= sum && r1 < sum + _sm.passenger_request_percentage.get(1).percentage) {

            }
            sum += _sm.passenger_request_percentage.get(1).percentage;
            if (r1 >= sum && r1 < sum + _sm.passenger_request_percentage.get(2).percentage) {

            }
            sum += _sm.passenger_request_percentage.get(2).percentage;
            if (r1 >= sum && r1 < sum + _sm.passenger_request_percentage.get(3).percentage) {

            }

        }
        return true;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
