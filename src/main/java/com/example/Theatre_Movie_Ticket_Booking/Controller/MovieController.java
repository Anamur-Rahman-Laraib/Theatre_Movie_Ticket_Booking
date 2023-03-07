package com.example.Theatre_Movie_Ticket_Booking.Controller;

import com.example.Theatre_Movie_Ticket_Booking.RequestDTOs.MovieEntryDto;
import com.example.Theatre_Movie_Ticket_Booking.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/add")
    public ResponseEntity<String> addMovie(@RequestBody MovieEntryDto movieEntryDto){

        try{
            String result = movieService.addMovie(movieEntryDto);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }catch (Exception e){
            String response = "Movie not added";
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }
    }
}
