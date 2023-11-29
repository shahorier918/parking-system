package com.parkingsystem;
import java.util.Scanner;

public class ParkingSystem {
    private static final int TOTAL_PARKING_SPOTS = 10;
    private static boolean[] parkingSpots = new boolean[TOTAL_PARKING_SPOTS];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to the Parking System");
            System.out.println("1. Park a car");
            System.out.println("2. Retrieve a car");
            System.out.println("3. Display parking status");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    parkCar();
                    break;
                case 2:
                    retrieveCar();
                    break;
                case 3:
                    displayParkingStatus();
                    break;
                case 4:
                    System.out.println("Thank you for using the Parking System. Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void parkCar() {
        int parkingSpot = findAvailableSpot();
        if (parkingSpot != -1) {
            parkingSpots[parkingSpot] = true;
            System.out.println("Car parked at spot " + (parkingSpot + 1));
        } else {
            System.out.println("Sorry, parking is full. Cannot park the car.");
        }
    }

    private static void retrieveCar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the parking spot number to retrieve the car:");
        int parkingSpot = scanner.nextInt() - 1;

        if (isValidSpot(parkingSpot) && parkingSpots[parkingSpot]) {
            parkingSpots[parkingSpot] = false;
            System.out.println("Car retrieved from spot " + (parkingSpot + 1));
        } else {
            System.out.println("Invalid parking spot or spot is empty. Please try again.");
        }
    }

    private static void displayParkingStatus() {
        System.out.println("\nParking Status:");
        for (int i = 0; i < TOTAL_PARKING_SPOTS; i++) {
            System.out.println("Spot " + (i + 1) + ": " + (parkingSpots[i] ? "Occupied" : "Available"));
        }
    }

    private static int findAvailableSpot() {
        for (int i = 0; i < TOTAL_PARKING_SPOTS; i++) {
            if (!parkingSpots[i]) {
                return i;
            }
        }
        return -1; // No available spot
    }

    private static boolean isValidSpot(int spot) {
        return spot >= 0 && spot < TOTAL_PARKING_SPOTS;
    }
}
