package com.example.Theatre_Movie_Ticket_Booking.Service;

import com.example.Theatre_Movie_Ticket_Booking.Convertor.MovieConvertor;
import com.example.Theatre_Movie_Ticket_Booking.Entities.MovieEntity;
import com.example.Theatre_Movie_Ticket_Booking.Repository.MovieRepository;
import com.example.Theatre_Movie_Ticket_Booking.RequestDTOs.MovieEntryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public String addMovie(MovieEntryDto movieEntryDto)throws Exception{


        MovieEntity movieEntity = MovieConvertor.convertEntryDtoToEntity(movieEntryDto);

        movieRepository.save(movieEntity);

        return "Movie Added successfully";


    }
}
