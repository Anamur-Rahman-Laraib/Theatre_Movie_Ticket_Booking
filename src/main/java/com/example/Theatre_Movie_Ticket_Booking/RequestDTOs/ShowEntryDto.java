package com.example.Theatre_Movie_Ticket_Booking.RequestDTOs;

import com.example.Theatre_Movie_Ticket_Booking.ENUMS.ShowType;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ShowEntryDto {
    private LocalDate localDate;

    private LocalTime localTime;

    private ShowType showType;

    private int movieId;

    private int theatreId;

    private int classicSeatPrice;

    private int premiumSeatPrice;
}
