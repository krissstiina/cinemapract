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

import com.cinemaPractic.demo.entites.Ticket;
import com.cinemaPractic.demo.model.TicketDTO;
import com.cinemaPractic.demo.repositories.impl.TicketRepositoryImpl;
import com.cinemaPractic.demo.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepositoryImpl ticketRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public void addTicket(TicketDTO ticket) {
        Ticket ticketToAdd = modelMapper.map(ticket, Ticket.class);

        ticketRepository.save(ticketToAdd);
    }
}

