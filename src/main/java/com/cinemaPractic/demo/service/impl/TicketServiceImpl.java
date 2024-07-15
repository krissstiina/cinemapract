package com.cinemaPractic.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinemaPractic.demo.entites.Ticket;
import com.cinemaPractic.demo.repositories.TicketRepository;
import com.cinemaPractic.demo.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;


    @Transactional
    @Override
    public void create(Ticket ticket) {
        ticketRepository.create(ticket);
    }

    @Transactional
    @Override
    public void delete(int id) {
        ticketRepository.delete(id);
    }


}