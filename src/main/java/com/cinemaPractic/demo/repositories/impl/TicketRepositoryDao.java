package com.cinemaPractic.demo.repositories.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cinemaPractic.demo.entites.Cinema;
import com.cinemaPractic.demo.entites.Film;
import com.cinemaPractic.demo.entites.Ticket;
import com.cinemaPractic.demo.repositories.TicketRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class TicketRepositoryDao implements TicketRepository {
    @Autowired
    private BaseTicketRepo baseTicketRepo;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public Ticket create(Ticket ticket) {
        return baseTicketRepo.save(ticket);
    }

    @Transactional
    @Override
    public Ticket update(Ticket ticket){
        return baseTicketRepo.save(ticket);
    }

    @Override
    public List<Ticket> findAll() {
        return baseTicketRepo.findAll();
    }

    @Override
    public Optional<Ticket> findById(int id){
        return baseTicketRepo.findById(id);
    }

}
interface BaseTicketRepo extends JpaRepository<Ticket, Integer> {

}
