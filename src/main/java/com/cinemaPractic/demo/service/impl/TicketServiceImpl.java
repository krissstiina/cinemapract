package com.cinemaPractic.demo.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinemaPractic.demo.entites.Cinema;
import com.cinemaPractic.demo.entites.Ticket;
import com.cinemaPractic.demo.model.CinemaDTO;
import com.cinemaPractic.demo.model.CreateCinemaDTO;
import com.cinemaPractic.demo.model.CreateTicketDTO;
import com.cinemaPractic.demo.model.TicketDTO;
import com.cinemaPractic.demo.model.UpdateCinemaDTO;
import com.cinemaPractic.demo.model.UpdateTicketDTO;
import com.cinemaPractic.demo.repositories.CinemaRepository;
import com.cinemaPractic.demo.repositories.TicketRepository;
import com.cinemaPractic.demo.repositories.impl.TicketRepositoryImpl;
import com.cinemaPractic.demo.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public TicketDTO create(CreateTicketDTO ticketCreateDto) {
        Ticket ticket = mapper.map(ticketCreateDto, Ticket.class);
        ticketRepository.create(ticket);
        return mapper.map(ticket, TicketDTO.class);
    }

    @Override
    public TicketDTO findById(int id) {
        Optional<Ticket> ticket = ticketRepository.findById(id);
        return mapper.map(ticket, TicketDTO.class);
    }

    

}

