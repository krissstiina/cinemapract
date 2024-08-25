package com.cinemaPractic.demo.repositories.impl;

import org.springframework.stereotype.Repository;
import com.cinemaPractic.demo.entites.Ticket;
import com.cinemaPractic.demo.repositories.BaseRepository;
import com.cinemaPractic.demo.repositories.TicketRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class TicketRepositoryImpl extends BaseRepository<Ticket, Integer> implements TicketRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public TicketRepositoryImpl(Class<Ticket> entity) {
        super(entity);
    }
}