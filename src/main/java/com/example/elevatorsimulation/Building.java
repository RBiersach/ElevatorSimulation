package com.example.elevatorsimulation;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Building {
    ArrayList<Floor> Floors = new ArrayList<>();
    SimulationSettings _sm = new SimulationSettings();

    public boolean scanFloors() {
        for (int i = 0; i < Floors.size(); i++) {
            Floors.get(i).loadAndUnload(_sm);
        }
        return true;
    }
}
