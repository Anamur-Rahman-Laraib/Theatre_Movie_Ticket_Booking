package com.example.Theatre_Movie_Ticket_Booking.Convertor;

import com.example.Theatre_Movie_Ticket_Booking.Entities.TheatreEntity;
import com.example.Theatre_Movie_Ticket_Booking.RequestDTOs.TheatreEntryDto;

public class TheatreConvertor {
    public static TheatreEntity convertDtoToEntity(TheatreEntryDto theaterEntryDto) {

        return TheatreEntity.builder().location(theaterEntryDto.getLocation())
                .name(theaterEntryDto.getName()).build();
     }

}
