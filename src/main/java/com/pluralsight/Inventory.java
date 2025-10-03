package com.pluralsight;

import java.util.Scanner;

public class Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vehicle[] vehicles = new Vehicle[20]; // array for up to 20 vehicles
        int vehicleCount = 0; // counter for number of vehicles stored

        // Preload 6 vehicles
        vehicles[vehicleCount++] = new Vehicle(101121, "Ford Explorer", "Red", 45000, 13500f);
        vehicles[vehicleCount++] = new Vehicle(101122, "Toyota Camry", "Blue", 60000, 11000f);
        vehicles[vehicleCount++] = new Vehicle(101123, "Chevrolet Malibu", "Black", 50000, 9700f);
        vehicles[vehicleCount++] = new Vehicle(101124, "Honda Civic", "White", 70000, 7500f);
        vehicles[vehicleCount++] = new Vehicle(101125, "Subaru Outback", "Green", 55000, 14500f);
        vehicles[vehicleCount++] = new Vehicle(101126, "Jeep Wrangler", "Yellow", 30000, 16000f);



        System.out.println("What do you want to do?");
        System.out.println(" 1 - List all vehicles");
        System.out.println(" 2 - Search by make/model");
        System.out.println(" 3 - Search by price range");
        System.out.println(" 4 - Search by color");
        System.out.println(" 5 - Add a vehicle");
        System.out.println(" 6 - Quit");
        System.out.println("Enter your command: ");

        int command = scanner.nextInt();
        switch(command) {
            case 1:
                listAllVehicles(vehicles, vehicleCount);
                break;
            case 2:
                //findVehiclesByPrice();
                break;
            case 5:
                //addAVehicle();
                break;
            case 6:
                return;
        }
    }

    public static void listAllVehicles (Vehicle[] vehicles, int vehicleCount) {
        // Print the vehicle list
        System.out.println("Preloaded Vehicles in Inventory:\n");

        for (int i = 0; i < vehicleCount; i++) {
            System.out.println(vehicles[i].toString());
        }

        System.out.println("\nTotal vehicles loaded: " + vehicleCount);
    }
}
