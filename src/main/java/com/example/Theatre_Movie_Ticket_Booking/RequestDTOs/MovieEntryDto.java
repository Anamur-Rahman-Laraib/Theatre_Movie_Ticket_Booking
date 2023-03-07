package com.example.Theatre_Movie_Ticket_Booking.RequestDTOs;

import com.example.Theatre_Movie_Ticket_Booking.ENUMS.Genre;
import com.example.Theatre_Movie_Ticket_Booking.ENUMS.Language;
import lombok.Data;

@Data
public class MovieEntryDto {
    private String movieName;

    private double ratings;

    private int duration;

    private Language language;

    private Genre genre;
}
