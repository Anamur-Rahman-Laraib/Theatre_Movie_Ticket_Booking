package com.example.Theatre_Movie_Ticket_Booking.Service;

import com.example.Theatre_Movie_Ticket_Booking.Convertor.UserConvertor;
import com.example.Theatre_Movie_Ticket_Booking.Entities.UserEntity;
import com.example.Theatre_Movie_Ticket_Booking.Repository.UserRepository;
import com.example.Theatre_Movie_Ticket_Booking.RequestDTOs.UserEntryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public String addUser(UserEntryDto userEntryDto)throws Exception,NullPointerException{

        UserEntity userEntity = UserConvertor.convertDtoToEntity(userEntryDto);

        userRepository.save(userEntity);

        return "User Added successfully";

    }
}
