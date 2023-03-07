package com.example.Theatre_Movie_Ticket_Booking.Repository;

import com.example.Theatre_Movie_Ticket_Booking.Entities.ShowEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<ShowEntity,Integer> {
}
