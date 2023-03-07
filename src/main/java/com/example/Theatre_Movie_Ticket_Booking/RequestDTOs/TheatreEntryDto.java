package com.example.Theatre_Movie_Ticket_Booking.RequestDTOs;

import lombok.Data;

@Data
public class TheatreEntryDto {
    private String name;
    private String location;

    private int classicSeatsCount;

    private int premiumSeatsCount;
}
