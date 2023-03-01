package com.example.Theatre_Movie_Ticket_Booking.RequestDTOs;

import lombok.Data;

@Data
public class UserEntryDto {
    private String name;

    private int age;

    private String email;

    private String mobNo;

    private String address;
}
