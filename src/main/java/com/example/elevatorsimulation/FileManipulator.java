package com.example.elevatorsimulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

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
                    sm.floors = Integer.parseInt(lineData[1]);
                } else if (lineData[0].equals("add_passenger")) {
                    AddPassenger passenger = new AddPassenger();
                    passenger.startingFloor = Integer.parseInt(lineData[2]);
                    passenger.destinationFloor = Integer.parseInt(lineData[3]);
                    passenger.passengerType = lineData[4];
                    passenger.passengerRequestPercentage = Integer.parseInt(lineData[5]);
                    sm.add_passenger.add(passenger);
                } else if (lineData[0].equals("elevator_type")) {
                    AddElevator elevator = new AddElevator();
                    elevator.elevatorType = lineData[1];
                    elevator.maximumCapacity = Integer.parseInt(lineData[2]);
                    elevator.elevatorRequestPercentage = Integer.parseInt(lineData[3]);
                    sm.add_elevator.add(elevator);
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
                    sm.run_simulation = Integer.parseInt(lineData[1]);
                }
                line = br.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return sm;

    }

//    private static TransactionsInformation creatTransactionInfo(String[] linedata, String[] attributes) {
//        TransactionsInformation transaction = new TransactionsInformation();
//        for (int i = 0; i < attributes.length; i++) {
//            if (attributes[i].toUpperCase().equals("customerid".toUpperCase())) {
//                transaction.customerID = Integer.parseInt(linedata[i]);
//            }
//            if (attributes[i].toUpperCase().equals("transactionid".toUpperCase())) {
//                transaction.transactionID = Integer.parseInt(linedata[i]);
//            }
//            if (attributes[i].toUpperCase().equals("transactiontype".toUpperCase())) {
//                transaction.transactionType = linedata[i];
//            }
//            if (attributes[i].toUpperCase().equals("transactiondate".toUpperCase())) {
//                transaction.transactionDate = linedata[i];
//            }
//            if (attributes[i].toUpperCase().equals("description".toUpperCase())) {
//                transaction.transactionDescription = linedata[i];
//            }
//            if (attributes[i].toUpperCase().equals("amount".toUpperCase())) {
//                transaction.amount = Float.parseFloat(linedata[i]);
//            }
//        }
//        if (transaction.customerID == HelloApplication.currentAccount.customerID) {
//            //String name = metadata[0];
//            return transaction;
//        } else {
//            return null;
//        }
//
//    }
//
//    public ArrayList<LoginInformation> readLoginInformation(String fileName) throws IOException {
//        ArrayList<LoginInformation> loginInformationList = new ArrayList<LoginInformation>();
//        Path pathToFile = Paths.get(fileDirectory + fileName);
//        System.out.println(pathToFile.toAbsolutePath());
//        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
//            String line = br.readLine();
//            String[] attributes = {};
//            if (line != null) {
//                attributes = line.split(",");
//            }
//            line = br.readLine();
//            while (line != null) {
//                String[] lineData = line.split(",");
//                LoginInformation loginInfo = creatLoginInfo(lineData, attributes);
//                loginInformationList.add(loginInfo);
//                line = br.readLine();
//            }
//        } catch (IOException ioe) {
//            ioe.printStackTrace();
//        }
//        return loginInformationList;
//
//    }
//
//    private static LoginInformation creatLoginInfo(String[] linedata, String[] attributes) {
//        LoginInformation login = new LoginInformation();
//        for (int i = 0; i < attributes.length; i++) {
//            if (attributes[i].toUpperCase().equals("customerid".toUpperCase())) {
//                login.customerID = Integer.parseInt(linedata[i]);
//            }
//            if (attributes[i].toUpperCase().equals("username".toUpperCase())) {
//                login.userName = linedata[i];
//            }
//            if (attributes[i].toUpperCase().equals("password".toUpperCase())) {
//                login.password = linedata[i];
//            }
//            if (attributes[i].toUpperCase().equals("creditlimit".toUpperCase())) {
//                login.creditLimit = Float.parseFloat(linedata[i]);
//            }
//        }
//        //String name = metadata[0];
//        return login;
//
//    }

}

