package com.cinemaPractic.demo.repositories.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
        entityManager.persist(ticket);
        return ticket;
    }

    @Transactional
    @Override
    public void delete(int id) {
        entityManager.remove(entityManager.find(Ticket.class, id));
    }

    @Transactional
    @Override
    public Ticket update(Ticket ticket){
        entityManager.persist(ticket);
        return ticket;
    }

    @Override
    public List<Ticket> findAll() {
        return baseTicketRepo.findAll();
    }

    @Override
    public Optional<Ticket> findById(int id){
        return baseTicketRepo.findById(id);
    }

    @Override
    public Ticket findTicketByUserAndSession(int userId, int sessionId) {
        return baseTicketRepo.findTicketByUserAndSession(userId, sessionId);
    }

}
interface BaseTicketRepo extends JpaRepository<Ticket, Integer> {

    @Query("SELECT t FROM Ticket t WHERE t.user.id = :userId AND t.session.id = :sessionId")
    Ticket findTicketByUserAndSession(
        @Param("userId") int userId,
        @Param("sessionId") int sessionId);

}
