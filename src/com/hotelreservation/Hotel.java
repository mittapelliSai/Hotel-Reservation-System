package com.hotelreservation;

import java.util.ArrayList;

public class Hotel {
    private ArrayList<Room> rooms;
    private ArrayList<Reservation> reservations;

    public Hotel() {
        rooms = new ArrayList<>();
        reservations = new ArrayList<>();
        initializeRooms();
    }

    private void initializeRooms() {
        rooms.add(new Room(101, "Single", 100));
        rooms.add(new Room(102, "Single", 100));
        rooms.add(new Room(201, "Double", 150));
        rooms.add(new Room(202, "Double", 150));
        rooms.add(new Room(301, "Suite", 300));
        rooms.add(new Room(302, "Suite", 300));
    }

    public ArrayList<Room> getAvailableRooms() {
        ArrayList<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.isAvailable()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    public Room getRoomByNumber(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }

    public void makeReservation(String guestName, int roomNumber, int nights) {
        Room room = getRoomByNumber(roomNumber);
        if (room != null && room.isAvailable()) {
            room.setAvailable(false);
            reservations.add(new Reservation(guestName, room, nights));
            System.out.println("Reservation successful for " + guestName);
        } else {
            System.out.println("Room not available.");
        }
    }

    public void viewReservations() {
        if (reservations.isEmpty()) {
            System.out.println("No reservations found.");
        } else {
            for (Reservation reservation : reservations) {
                System.out.println("Guest: " + reservation.getGuestName());
                System.out.println("Room: " + reservation.getRoom().getRoomNumber());
                System.out.println("Category: " + reservation.getRoom().getCategory());
                System.out.println("Nights: " + reservation.getNights());
                System.out.println("Total Amount: $" + reservation.getTotalAmount());
                System.out.println();
            }
        }
    }
}

