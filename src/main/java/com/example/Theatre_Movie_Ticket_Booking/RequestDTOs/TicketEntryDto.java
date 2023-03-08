package com.example.Theatre_Movie_Ticket_Booking.RequestDTOs;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TicketEntryDto {
    private int showId;

    private List<String> requestedSeats = new ArrayList<>();

    private int userId;
}
