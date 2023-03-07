package com.example.Theatre_Movie_Ticket_Booking.Repository;

import com.example.Theatre_Movie_Ticket_Booking.Entities.TheatreSeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreSeatRepository extends JpaRepository<TheatreSeatEntity, Integer> {
}
