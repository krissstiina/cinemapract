package com.cinemaPractic.demo.repositories.impl;

import com.cinemaPractic.demo.entites.Ticket;
import com.cinemaPractic.demo.repositories.TicketRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class TicketRepositoryDao implements TicketRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addTicket(Ticket ticket) {
        entityManager.persist(ticket);
    }

    @Override
    public void create(Ticket ticket) {
        entityManager.persist(ticket);
    }

    @Override
    public void delete(int id) {
        entityManager.remove(entityManager.find(Ticket.class, id));
    }

}
