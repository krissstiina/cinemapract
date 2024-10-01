package com.cinemaPractic.demo.config;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cinemaPractic.demo.entites.Hall;
import com.cinemaPractic.demo.entites.Session;
import com.cinemaPractic.demo.entites.Ticket;
import com.cinemaPractic.demo.model.HallDTO;
import com.cinemaPractic.demo.model.SessionDTO;
import com.cinemaPractic.demo.model.TicketDTO;

@Configuration
public class MapperConfig {
    private final ModelMapper mapper;

    public MapperConfig(){
        mapper = new ModelMapper();

        mapper
            .typeMap(Hall.class, HallDTO.class)
            .addMappings(map -> {
                map.map(hall -> hall.getId(), HallDTO::setId);
                map.map(hall -> hall.getCinema().getId(), HallDTO::setCinemaId);
                map.map(hall -> hall.getCapacity(), HallDTO::setCapacity);
            }
        );

        mapper
            .typeMap(Session.class, SessionDTO.class)
            .addMappings(map -> {
                map.map(session -> session.getId(), SessionDTO::setId);
                map.map(session -> session.getCinema().getId(), SessionDTO::setCinemaId);
                map.map(session -> session.getHall().getId(), SessionDTO::setHallId);
                map.map(session -> session.getFilm().getId(), SessionDTO::setFilmId);
                map.map(session -> session.getAvailableSeats(), SessionDTO::setAvailableSeats);
                map.map(session -> session.getDate(), SessionDTO::setDate);
            }
        );

        mapper
            .typeMap(Ticket.class, TicketDTO.class)
            .addMappings(map -> {
                map.map(ticket -> ticket.getId(), TicketDTO::setId);
                map.map(ticket -> ticket.getSession().getId(), TicketDTO::setSessionId);
                map.map(ticket -> ticket.getUser().getId(), TicketDTO::setUserId);
                map.map(ticket -> ticket.getPrice(), TicketDTO::setPrice);
            }
        );
    }

    @Bean
    public ModelMapper modelMapper(){
        return mapper;
    }

}
