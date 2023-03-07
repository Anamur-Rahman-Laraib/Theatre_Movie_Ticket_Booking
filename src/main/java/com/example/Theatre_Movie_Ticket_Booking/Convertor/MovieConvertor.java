package com.example.Theatre_Movie_Ticket_Booking.Convertor;

import com.example.Theatre_Movie_Ticket_Booking.Entities.MovieEntity;
import com.example.Theatre_Movie_Ticket_Booking.RequestDTOs.MovieEntryDto;

public class MovieConvertor {
    public static MovieEntity convertEntryDtoToEntity(MovieEntryDto movieEntryDto){

        MovieEntity movieEntity = MovieEntity.builder()
                .movieName(movieEntryDto.getMovieName()).duration(movieEntryDto.getDuration())
                .genre(movieEntryDto.getGenre()).language(movieEntryDto.getLanguage()).ratings(movieEntryDto.getRatings()).build();

        return movieEntity;
    }
}
