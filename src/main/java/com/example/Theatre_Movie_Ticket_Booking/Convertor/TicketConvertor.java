package com.example.Theatre_Movie_Ticket_Booking.Convertor;

import com.example.Theatre_Movie_Ticket_Booking.Entities.TicketEntity;
import com.example.Theatre_Movie_Ticket_Booking.RequestDTOs.TicketEntryDto;

public class TicketConvertor {
    public static TicketEntity convertEntryToEntity(TicketEntryDto ticketEntryDto){

        TicketEntity ticketEntity = new TicketEntity();
        return ticketEntity;

    }
}
