package com.cinemaPractic.demo.service.impl;

import java.util.Optional;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinemaPractic.demo.entites.Ticket;
import com.cinemaPractic.demo.exception.TicketNotFoundException;
import com.cinemaPractic.demo.model.CreateTicketDTO;
import com.cinemaPractic.demo.model.TicketDTO;
import com.cinemaPractic.demo.model.UpdateTicketDTO;
import com.cinemaPractic.demo.repositories.TicketRepository;
import com.cinemaPractic.demo.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;
    ModelMapper modelMapper = new ModelMapper();

    @Override
    public TicketDTO create(CreateTicketDTO ticketDTO) {
        Ticket ticket = modelMapper.map(ticketDTO,Ticket.class);
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
        Optional<Ticket> ticket = ticketRepository.findById(ticketDTO.id);
        if (!ticket.isPresent()){
            throw new TicketNotFoundException();
        }
        ticketRepository.update(ticket.get());
        return modelMapper.map(ticket,TicketDTO.class);
    }

    @Override
    public List<TicketDTO> findAll() {
        return ticketRepository.findAll().stream().map((ticket) -> modelMapper.map(ticket,TicketDTO.class)).toList();
    }

}