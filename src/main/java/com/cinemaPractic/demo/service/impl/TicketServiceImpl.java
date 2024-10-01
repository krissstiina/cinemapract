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
import com.cinemaPractic.demo.entites.Film;
import com.cinemaPractic.demo.entites.Hall;
import com.cinemaPractic.demo.entites.Session;
import com.cinemaPractic.demo.entites.Ticket;
import com.cinemaPractic.demo.entites.User;
import com.cinemaPractic.demo.exception.SessionNotFoundException;
import com.cinemaPractic.demo.exception.UserNotFoundException;
import com.cinemaPractic.demo.exception.HallNotFoundException;
import com.cinemaPractic.demo.model.CinemaDTO;
import com.cinemaPractic.demo.model.CreateCinemaDTO;
import com.cinemaPractic.demo.model.CreateSessionDTO;
import com.cinemaPractic.demo.model.CreateTicketDTO;
import com.cinemaPractic.demo.model.SessionDTO;
import com.cinemaPractic.demo.model.TicketDTO;
import com.cinemaPractic.demo.model.UpdateCinemaDTO;
import com.cinemaPractic.demo.model.UpdateTicketDTO;
import com.cinemaPractic.demo.repositories.CinemaRepository;
import com.cinemaPractic.demo.repositories.SessionRepository;
import com.cinemaPractic.demo.repositories.TicketRepository;
import com.cinemaPractic.demo.repositories.UserRepository;
import com.cinemaPractic.demo.repositories.impl.TicketRepositoryImpl;
import com.cinemaPractic.demo.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private SessionRepository sessionRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public TicketDTO create(CreateTicketDTO ticketDTO) {
        Session session = sessionRepository.findById(ticketDTO.getSession()).orElseThrow(() -> new SessionNotFoundException());
        Optional<User> user = userRepository.findById(ticketDTO.getUser());

        if (user.isEmpty()) {
            throw new UserNotFoundException();
        }

        Ticket ticket = new Ticket(ticketDTO.price, session, user.get());
        ticketRepository.create(ticket);
        return mapper.map(ticket, TicketDTO.class);
    }

    @Override
    public Optional<TicketDTO> findById(int id){
        Optional<Ticket> ticket = ticketRepository.findById(id);
        if (!ticket.isPresent()){
            throw new SessionNotFoundException();
        }
        return Optional.of(mapper.map(ticket,TicketDTO.class));
    }

    

}

