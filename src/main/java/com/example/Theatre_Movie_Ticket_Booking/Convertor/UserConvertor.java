package com.example.Theatre_Movie_Ticket_Booking.Convertor;

import com.example.Theatre_Movie_Ticket_Booking.Entities.UserEntity;
import com.example.Theatre_Movie_Ticket_Booking.RequestDTOs.UserEntryDto;

public class UserConvertor {
    public static UserEntity convertDtoToEntity(UserEntryDto userEntryDto){

        UserEntity userEntity =  UserEntity.builder().age(userEntryDto.getAge()).address(userEntryDto.getAddress())
                .email(userEntryDto.getEmail()).name(userEntryDto.getName()).mobNo(userEntryDto.getMobNo())
                .build();

        return userEntity;

    }
}
