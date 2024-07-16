package com.cinemaPractic.demo.service.impl;

import java.util.Optional;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinemaPractic.demo.entites.Film;
import com.cinemaPractic.demo.entites.Hall;
import com.cinemaPractic.demo.entites.Session;
import com.cinemaPractic.demo.entites.Ticket;
import com.cinemaPractic.demo.entites.User;
import com.cinemaPractic.demo.exception.FilmNotFoundException;
import com.cinemaPractic.demo.exception.HallNotFoundException;
import com.cinemaPractic.demo.exception.SessionNotFoundException;
import com.cinemaPractic.demo.exception.TicketNotFoundException;
import com.cinemaPractic.demo.exception.UserNotFoundException;
import com.cinemaPractic.demo.model.CreateTicketDTO;
import com.cinemaPractic.demo.model.SessionDTO;
import com.cinemaPractic.demo.model.TicketDTO;
import com.cinemaPractic.demo.model.UpdateTicketDTO;
import com.cinemaPractic.demo.repositories.SessionRepository;
import com.cinemaPractic.demo.repositories.TicketRepository;
import com.cinemaPractic.demo.repositories.UserRepository;
import com.cinemaPractic.demo.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private UserRepository userRepository;
    
    private ModelMapper modelMapper;
    public TicketServiceImpl(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    @Override
    public TicketDTO create(CreateTicketDTO ticketDTO) {
        Session session = sessionRepository.findById(ticketDTO.getSession()).orElseThrow(() -> new SessionNotFoundException());
        User user = userRepository.findById(ticketDTO.getUser()).orElseThrow(() -> new UserNotFoundException());
        
        Ticket ticket = new Ticket(ticketDTO.getPrice(),session, user);
        ticketRepository.create(ticket);
        return modelMapper.map(ticket, TicketDTO.class);
    }

    @Override
    public void delete(int id) {
        ticketRepository.delete(id);
    }

    @Override
    public Optional<TicketDTO> findById(int id){
        Optional<Ticket> ticket = ticketRepository.findById(id);
        if (!ticket.isPresent()){
            throw new TicketNotFoundException();
        }
        return Optional.of(modelMapper.map(ticket,TicketDTO.class));
    }

    @Override
    public TicketDTO update(UpdateTicketDTO ticketDTO) {
        Optional<Ticket> ticket = ticketRepository.findById(ticketDTO.getId());
        if (!ticket.isPresent()) {
            throw new TicketNotFoundException();
        }

        if(ticketDTO.getSession() != 0) {
            Session session = sessionRepository.findById(ticketDTO.getSession()).orElseThrow(() -> new SessionNotFoundException());
            ticket.get().setSession(session);
        }

        if(ticketDTO.getUser() != 0) {
            User user = userRepository.findById(ticketDTO.getUser()).orElseThrow(() -> new UserNotFoundException());
            ticket.get().setUser(user);
        }

        ticket.get().setPrice(ticketDTO.getPrice());
        ticketRepository.update(ticket.get());

        return modelMapper.map(ticket, TicketDTO.class);
    }

    @Override
    public List<TicketDTO> findAll() {
        return ticketRepository.findAll().stream().map((ticket) -> modelMapper.map(ticket,TicketDTO.class)).toList();
    }
}

// public class BonusService {

//     private final TicketRepository ticketRepository;
//     private final UserRepository userRepository;

//     public BonusService(TicketRepository ticketRepository, UserRepository userRepository) {
//         this.ticketRepository = ticketRepository;
//         this.userRepository = userRepository;
//     }

//     public void addBonusPoints(int id) {
//         User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Пользователь не найден"));

//         List<Ticket> tickets = ticketRepository.findTicketsByUser(id);
//         int bonusPoints = tickets.size(); // 1 билет = 1 балл

//         user.setPoints(user.getPoints() + bonusPoints);
//         userRepository.save(user);
//     }

//     public int getBonusPointsValue(int bonusPoints) {
//         return bonusPoints * 10; // 1 балл = 10 рублей
//     }


// }