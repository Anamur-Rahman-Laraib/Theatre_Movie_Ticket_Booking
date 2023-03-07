package com.example.Theatre_Movie_Ticket_Booking.Convertor;

import com.example.Theatre_Movie_Ticket_Booking.Entities.ShowEntity;
import com.example.Theatre_Movie_Ticket_Booking.RequestDTOs.ShowEntryDto;

public class ShowConvertor {
    public static ShowEntity convertEntryToEntity(ShowEntryDto showEntryDto){

        ShowEntity showEntity = ShowEntity.builder()
                .showDate(showEntryDto.getLocalDate())
                .showTime(showEntryDto.getLocalTime())
                .showType(showEntryDto.getShowType())
                .build();

        return showEntity;
    }
}
