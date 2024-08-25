package com.hotelreservation;

public class Reservation {
    private String guestName;
    private Room room;
    private int nights;
    private double totalAmount;

    public Reservation(String guestName, Room room, int nights) {
        this.guestName = guestName;
        this.room = room;
        this.nights = nights;
        this.totalAmount = room.getPrice() * nights;
    }

    public String getGuestName() {
        return guestName;
    }

    public Room getRoom() {
        return room;
    }

    public int getNights() {
        return nights;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}


