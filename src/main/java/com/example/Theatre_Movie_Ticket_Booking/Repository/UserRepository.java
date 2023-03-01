package com.example.Theatre_Movie_Ticket_Booking.Repository;

import com.example.Theatre_Movie_Ticket_Booking.Entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
