package com.cinemaPractic.demo.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;

import com.cinemaPractic.demo.entites.Hall;
import com.cinemaPractic.demo.entites.Session;
import com.cinemaPractic.demo.entites.Ticket;
import com.cinemaPractic.demo.model.HallDTO;
import com.cinemaPractic.demo.model.SessionDTO;
import com.cinemaPractic.demo.model.TicketDTO;

public class Mapper {
    private static ModelMapper modelMapperInstance;

    public static ModelMapper getModelMapper() {
        if (modelMapperInstance == null) {
        modelMapperInstance = new Mapper().createMapper(new ModelMapper());
    }

    return modelMapperInstance;
    }

    private ModelMapper createMapper(ModelMapper modelMapper) {
        TypeMap<Hall, HallDTO> hallToDTO = modelMapper.createTypeMap(Hall.class, HallDTO.class);
        hallToDTO.addMappings(mapper -> {
            mapper.map(hall -> hall.getCinema().getId(), HallDTO::setCinema);
            mapper.map(hall -> hall.getCapacity(), HallDTO::setCapacity);
        });

        TypeMap<Session, SessionDTO> sessionToDTO = modelMapper.createTypeMap(Session.class, SessionDTO.class);
        sessionToDTO.addMappings(mapper -> {
            mapper.map(session -> session.getDate(), SessionDTO::setDate);
            mapper.map(session -> session.getHall().getId(), SessionDTO::setHall);
            mapper.map(session -> session.getFilm().getId(), SessionDTO::setFilm);
            mapper.map(session -> session.getCinema().getId(), SessionDTO::setCinema);
            mapper.map(session -> session.getAvailableSeats(), SessionDTO::setAvailableSeats);
        });

        TypeMap<Ticket, TicketDTO> ticketToDTO = modelMapper.createTypeMap(Ticket.class, TicketDTO.class);
        ticketToDTO.addMappings(mapper -> {
            mapper.map(ticket -> ticket.getPrice(), TicketDTO::setPrice);
            mapper.map(ticket -> ticket.getSession().getId(), TicketDTO::setSession);
            mapper.map(ticket -> ticket.getUser().getId(), TicketDTO::setUser);
        });
        return modelMapper;
    }
}
