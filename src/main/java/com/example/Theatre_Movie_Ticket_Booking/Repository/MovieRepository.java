package com.example.Theatre_Movie_Ticket_Booking.Repository;

import com.example.Theatre_Movie_Ticket_Booking.Entities.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<MovieEntity, Integer> {
}
