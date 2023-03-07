package com.example.Theatre_Movie_Ticket_Booking.Repository;

import com.example.Theatre_Movie_Ticket_Booking.Entities.TheatreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheatreRepository extends JpaRepository<TheatreEntity,Integer> {
}
