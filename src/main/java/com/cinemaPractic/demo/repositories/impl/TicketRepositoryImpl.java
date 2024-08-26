package com.cinemaPractic.demo.repositories.impl;

import org.springframework.stereotype.Repository;
import com.cinemaPractic.demo.entites.Ticket;
import com.cinemaPractic.demo.repositories.TicketRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class TicketRepositoryImpl extends BaseRepositoryImpl<Ticket> implements TicketRepository {

    public TicketRepositoryImpl() {
        super(Ticket.class);
    }
}