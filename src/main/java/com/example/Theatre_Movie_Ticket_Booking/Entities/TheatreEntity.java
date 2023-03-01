package com.example.Theatre_Movie_Ticket_Booking.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "theaters")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class TheatreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String location;

    //This is the parent wrt to theaterSeats
    @OneToMany(mappedBy = "theatreEntity",cascade = CascadeType.ALL)//mapped by contains the foreign key name in child class
    private List<TheatreSeatEntity> theatreSeatEntityList = new ArrayList<>();

    //This is parent wrt showEntity
    @OneToMany(mappedBy = "theatreEntity",cascade = CascadeType.ALL)
    private List<ShowEntity> showEntityList = new ArrayList<>();
}
