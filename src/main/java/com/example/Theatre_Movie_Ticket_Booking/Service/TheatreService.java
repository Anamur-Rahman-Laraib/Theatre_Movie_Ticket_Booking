package com.example.Theatre_Movie_Ticket_Booking.Service;

import com.example.Theatre_Movie_Ticket_Booking.Convertor.TheatreConvertor;
import com.example.Theatre_Movie_Ticket_Booking.ENUMS.SeatType;
import com.example.Theatre_Movie_Ticket_Booking.Entities.TheatreEntity;
import com.example.Theatre_Movie_Ticket_Booking.Entities.TheatreSeatEntity;
import com.example.Theatre_Movie_Ticket_Booking.Repository.TheatreRepository;
import com.example.Theatre_Movie_Ticket_Booking.Repository.TheatreSeatRepository;
import com.example.Theatre_Movie_Ticket_Booking.RequestDTOs.TheatreEntryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheatreService {
    @Autowired
    TheatreSeatRepository theatreSeatRepository;


    @Autowired
    TheatreRepository theatreRepository;

    public String addTheatre(TheatreEntryDto theatreEntryDto)throws Exception{


        //Do some validations :
        if(theatreEntryDto.getName()==null||theatreEntryDto.getLocation()==null){
            throw new Exception("Name and location should valid");
        }

        TheatreEntity theatreEntity = TheatreConvertor.convertDtoToEntity(theatreEntryDto);
        List<TheatreSeatEntity> theatreSeatEntityList = createTheatreSeats(theatreEntryDto,theatreEntity);

        theatreEntity.setTheatreSeatEntityList(theatreSeatEntityList);
        theatreRepository.save(theatreEntity);

        return "Theatre Added successfully";
    }

    private List<TheatreSeatEntity> createTheatreSeats(TheatreEntryDto theatreEntryDto,TheatreEntity theatreEntity){

        int noClassicSeats = theatreEntryDto.getClassicSeatsCount();
        int noPremiumSeats = theatreEntryDto.getPremiumSeatsCount();

        List<TheatreSeatEntity> theatreSeatEntityList = new ArrayList<>();

        //Created the classic Seats
        for(int count = 1;count<=noClassicSeats;count++){

            //We need to make a new TheaterSeatEntity
            TheatreSeatEntity theatreSeatEntity = TheatreSeatEntity.builder()
                    .seatType(SeatType.CLASSIC).seatNo(count+"C")
                    .theatreEntity(theatreEntity).build();

            theatreSeatEntityList.add(theatreSeatEntity);
        }


        //Create the premium Seats
        for(int count=1;count<=noPremiumSeats;count++){

            TheatreSeatEntity theatreSeatEntity = TheatreSeatEntity.builder().
                    seatType(SeatType.PREMIUM).seatNo(count+"P").theatreEntity(theatreEntity).build();

            theatreSeatEntityList.add(theatreSeatEntity);
        }

        //Not saving the child here
        return theatreSeatEntityList;

    }
}
