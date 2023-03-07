package com.example.Theatre_Movie_Ticket_Booking.Service;

import com.example.Theatre_Movie_Ticket_Booking.Convertor.ShowConvertor;
import com.example.Theatre_Movie_Ticket_Booking.ENUMS.SeatType;
import com.example.Theatre_Movie_Ticket_Booking.Entities.*;
import com.example.Theatre_Movie_Ticket_Booking.Repository.MovieRepository;
import com.example.Theatre_Movie_Ticket_Booking.Repository.ShowRepository;
import com.example.Theatre_Movie_Ticket_Booking.Repository.TheatreRepository;
import com.example.Theatre_Movie_Ticket_Booking.RequestDTOs.ShowEntryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {
    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheatreRepository theatreRepository;

    @Autowired
    ShowRepository showRepository;

    public String addShow(ShowEntryDto showEntryDto)
    {
        //1. Create a showEntity
        ShowEntity showEntity = ShowConvertor.convertEntryToEntity(showEntryDto);

        int movieId = showEntryDto.getMovieId();
        int theatreId = showEntryDto.getTheatreId();

        MovieEntity movieEntity = movieRepository.findById(movieId).get();
        TheatreEntity theatreEntity = theatreRepository.findById(theatreId).get();


        //Setting the attribute of foreignKe
        showEntity.setMovieEntity(movieEntity);
        showEntity.setTheatreEntity(theatreEntity);

        //Pending attributes the listOfShowSeatsEnity

        List<ShowSeatEntity> seatEntityList = createShowSeatEntity(showEntryDto,showEntity);

        showEntity.setListOfShowSeats(seatEntityList);


        //Now we  also need to update the parent entities


        showEntity = showRepository.save(showEntity);

        movieEntity.getShowEntityList().add(showEntity);
        theatreEntity.getShowEntityList().add(showEntity);


        movieRepository.save(movieEntity);

        theatreRepository.save(theatreEntity);

        return "The show has been added successfully";

    }

    private List<ShowSeatEntity> createShowSeatEntity(ShowEntryDto showEntryDto,ShowEntity showEntity){



        //Now the goal is to create the ShowSeatEntity
        //We need to set its attribute

        TheatreEntity theatreEntity = showEntity.getTheatreEntity();

        List<TheatreSeatEntity> theatreSeatEntityList = theatreEntity.getTheatreSeatEntityList();

        List<ShowSeatEntity> seatEntityList = new ArrayList<>();

        for(TheatreSeatEntity theatreSeatEntity : theatreSeatEntityList){

            ShowSeatEntity showSeatEntity = new ShowSeatEntity();

            showSeatEntity.setSeatNo(theatreSeatEntity.getSeatNo());
            showSeatEntity.setSeatType(theatreSeatEntity.getSeatType());

            if(theatreSeatEntity.getSeatType().equals(SeatType.CLASSIC))
                showSeatEntity.setPrice(showEntryDto.getClassicSeatPrice());

            else
                showSeatEntity.setPrice(showEntryDto.getPremiumSeatPrice());

            showSeatEntity.setBooked(false);
            showSeatEntity.setShowEntity(showEntity); //parent : foreign key for the showSeat Entity

            seatEntityList.add(showSeatEntity); //Adding it to the list
        }

        return  seatEntityList;

    }
}
