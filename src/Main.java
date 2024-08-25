package com.hotelreservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. View Available Rooms");
            System.out.println("2. Make a Reservation");
            System.out.println("3. View Reservations");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            if (scanner.hasNextInt()) {
                int option = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                switch (option) {
                    case 1:
                        System.out.println("Available Rooms:");
                        for (Room room : hotel.getAvailableRooms()) {
                            System.out.println("Room Number: " + room.getRoomNumber() +
                                    ", Category: " + room.getCategory() +
                                    ", Price: $" + room.getPrice());
                        }
                        break;
                    case 2:
                        System.out.print("Enter guest name: ");
                        String guestName = scanner.nextLine();
                        System.out.print("Enter room number: ");
                        int roomNumber = scanner.nextInt();
                        System.out.print("Enter number of nights: ");
                        int nights = scanner.nextInt();
                        hotel.makeReservation(guestName, roomNumber, nights);
                        break;
                    case 3:
                        hotel.viewReservations();
                        break;
                    case 4:
                        System.out.println("Exiting program.");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid option. Try again.");
                }
            } else {
                System.out.println("Invalid option. Please enter a number.");
                scanner.nextLine();  // Clear the invalid input
            }
        }
    }
}

