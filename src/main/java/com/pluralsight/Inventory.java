package com.pluralsight;
import java.util.Scanner;

public class Inventory {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[20]; // my garage will fit only 20 cars
        int vehicleCount = 0;

        // Load initial vehicles into inventory
        vehicleCount = preloadVehicles(vehicles, vehicleCount);

        int command = 0;

        // Display menu options and handle user commands
        while (command != 6) {
            displayMenu();
            System.out.print("Enter your command: ");

            if (scanner.hasNextInt()) {
                command = scanner.nextInt();
                scanner.nextLine(); // consume the newline

                switch (command) {
                    case 1:
                        listAllVehicles(vehicles, vehicleCount);
                        break;
                    case 2:
                        findVehiclesByMake(vehicles);
                        break;
                    case 3:
                        findVehiclesByPrice(vehicles);
                        break;
                    case 4:
                        findVehiclesByColor(vehicles);
                        break;
                    case 5:
                        vehicleCount = addAVehicle(vehicles, vehicleCount);
                        break;
                    case 6:
                        System.out.println("Exiting program. Goodbye!");
                        scanner.close();
                        break;
                    default:
                        System.out.println("Invalid command. Please try again.");
                }
            } else {
                System.out.println("Please enter a valid number.");
                scanner.nextLine(); // clear invalid input
            }
        }
    }

    // Displays menu options
    private static void displayMenu() {
        System.out.println("\n===== Vehicle Inventory Menu =====");
        System.out.println(" 1 - List all vehicles");
        System.out.println(" 2 - Search by make/model");
        System.out.println(" 3 - Search by price range");
        System.out.println(" 4 - Search by color");
        System.out.println(" 5 - Add a vehicle");
        System.out.println(" 6 - Quit");
    }

    // Preloads a set of sample vehicles
    private static int preloadVehicles(Vehicle[] vehicles, int count) {
        vehicles[count++] = new Vehicle(101121, "Ford Explorer", "Red", 45000, 13500f);
        vehicles[count++] = new Vehicle(101122, "Toyota Camry", "Blue", 60000, 11000f);
        vehicles[count++] = new Vehicle(101123, "Chevrolet Malibu", "Black", 50000, 9700f);
        vehicles[count++] = new Vehicle(101124, "Honda Civic", "White", 70000, 7500f);
        vehicles[count++] = new Vehicle(101125, "Subaru Outback", "Green", 55000, 14500f);
        vehicles[count++] = new Vehicle(101126, "Jeep Wrangler", "Yellow", 30000, 16000f);
        System.out.println("Loaded " + count + " sample vehicles into inventory.");
        return count;
    }

    // Lists all vehicles currently in the inventory
    private static void listAllVehicles(Vehicle[] vehicles, int count) {
        System.out.println("\n📋 Vehicles in Inventory:");
        for (int i = 0; i < count; i++) {
            System.out.println(vehicles[i]);
        }
        System.out.println("Total vehicles: " + count);
    }

    // Search vehicles by make/model
    private static void findVehiclesByMake(Vehicle[] vehicles) {
        System.out.print("Enter the make/model to search: ");
        String makeModel = scanner.nextLine().trim().toLowerCase();

        boolean found = false;
        for (Vehicle vehicle : vehicles) {
            if (vehicle != null && vehicle.getMakeModel().toLowerCase().contains(makeModel)) {
                System.out.println(vehicle);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No vehicles found with make/model containing: " + makeModel);
        }
    }

    // Search vehicles by price range
    private static void findVehiclesByPrice(Vehicle[] vehicles) {
        System.out.print("Enter minimum price: ");
        float minPrice = scanner.nextFloat();
        scanner.nextLine(); // consume newline

        System.out.print("Enter maximum price: ");
        float maxPrice = scanner.nextFloat();
        scanner.nextLine(); // consume newline

        boolean found = false;
        for (Vehicle vehicle : vehicles) {
            if (vehicle != null && vehicle.getPrice() >= minPrice && vehicle.getPrice() <= maxPrice) {
                System.out.println(vehicle);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No vehicles found in the price range $" + minPrice + " - $" + maxPrice);
        }
    }

    // Search vehicles by color
    private static void findVehiclesByColor(Vehicle[] vehicles) {
        System.out.print("Enter the color to search: ");
        String color = scanner.nextLine().trim().toLowerCase();

        boolean found = false;
        for (Vehicle vehicle : vehicles) {
            if (vehicle != null && vehicle.getColor().toLowerCase().equals(color)) {
                System.out.println(vehicle);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No vehicles found with color: " + color);
        }
    }

    // Adds a new vehicle to the inventory
    private static int addAVehicle(Vehicle[] vehicles, int count) {
        if (count >= vehicles.length) {
            System.out.println("Inventory is full. Cannot add more vehicles.");
            return count;
        }

        System.out.println("\n🆕 Adding a New Vehicle");

        System.out.print("Enter vehicle ID: ");
        long id = scanner.nextLong();
        scanner.nextLine();

        System.out.print("Enter make/model: ");
        String makeModel = scanner.nextLine();

        System.out.print("Enter color: ");
        String color = scanner.nextLine();

        System.out.print("Enter odometer reading: ");
        int odometer = scanner.nextInt();

        System.out.print("Enter price: ");
        float price = scanner.nextFloat();
        scanner.nextLine(); // consume newline

        vehicles[count++] = new Vehicle(id, makeModel, color, odometer, price);

        System.out.println("✅ Vehicle added successfully!");

        return count;
    }
}
