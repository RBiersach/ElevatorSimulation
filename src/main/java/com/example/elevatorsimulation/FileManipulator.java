package com.example.elevatorsimulation;

import com.example.elevatorsimulation.Elevators.*;
import com.example.elevatorsimulation.Passengers.Passenger;
import com.example.elevatorsimulation.Passengers.StandardPassenger;
import com.example.elevatorsimulation.Passengers.FreightPassenger;
import com.example.elevatorsimulation.Passengers.GlassPassenger;
import com.example.elevatorsimulation.Passengers.VipPassenger;


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManipulator {
    public String fileDirectory;

    public FileManipulator(String directory) {
        this.fileDirectory = directory;
    }

    public FileManipulator() {
        this.fileDirectory = "C:\\Users\\thren\\OneDrive\\Desktop\\Farmingdale\\Fall 2023\\CSC 211\\ElevatorSimulation\\src\\main\\resources\\";

    }

    public SimulationSettings readSettingsInformation(String fileName) throws IOException {
        SimulationSettings sm = new SimulationSettings();
        Path pathToFile = Paths.get(fileDirectory + fileName);
        System.out.println(pathToFile.toAbsolutePath());
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
            String line = br.readLine();

            while (line != null) {
                String[] lineData = line.split(" ");
                if (lineData[0].equals("floors")) {
                    sm.number_of_floors = Integer.parseInt(lineData[1]);
                } else if (lineData[0].equals("add_passenger")) {
                    PassengerInformation passengerInformation = new PassengerInformation();
                    passengerInformation.startingFloor = Integer.parseInt(lineData[2]);
                    passengerInformation.destinationFloor = Integer.parseInt(lineData[3]);
                    passengerInformation.typeOfPassenger = lineData[4];
                    passengerInformation.passengerRequestPercentage = Integer.parseInt(lineData[5]);
                    sm.passengerInformationArrayList.add(passengerInformation);

                } else if (lineData[0].equals("elevator_type")) {
                    ElevatorInformation elevatorInformation = new ElevatorInformation();
                    elevatorInformation.elevatorType = lineData[1];
                    elevatorInformation.maximumCapacity = Integer.parseInt(lineData[2]);
                    elevatorInformation.elevatorRequestPercentage = Integer.parseInt(lineData[3]);
                    sm.elevatorInformationArrayList.add(elevatorInformation);


                } else if (lineData[0].equals("request_percentage")) {
                    ElevatorRequestPercentage erp = new ElevatorRequestPercentage();
                    erp.elevatorType = lineData[1];
                    erp.percentage = Integer.parseInt(lineData[2]);
                    sm.elevator_request_percentage.add(erp);
                } else if (lineData[0].equals("passenger_request_percentage")) {
                    PassengerRequestPercentage prp = new PassengerRequestPercentage();
                    prp.passengerType = lineData[1];
                    prp.percentage = Integer.parseInt(lineData[2]);
                    sm.passenger_request_percentage.add(prp);
                } else if (lineData[0].equals("number_of_elevators")) {
                    sm.number_of_elevators = Integer.parseInt(lineData[1]);
                } else if (lineData[0].equals("run_simulation")) {
                    sm.iterations = Integer.parseInt(lineData[1]);
                }
                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return sm;

    }

}
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
      
        
     

