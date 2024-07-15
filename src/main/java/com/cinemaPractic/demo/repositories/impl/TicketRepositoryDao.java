package com.cinemaPractic.demo.repositories.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

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


    @Override
    public void create(Ticket ticket) {
        entityManager.persist(ticket);
    }

    @Override
    public void findByUserId(int id){
        entityManager.persist(id);
    }

    @Override
    public void delete(int id) {
        entityManager.remove(entityManager.find(Ticket.class, id));
    }

    @Override
    public List<Ticket> findTicketByUserId(int id) {
        return baseTicketRepo.findTicketByUserId(id);
    }
}
interface BaseTicketRepo extends JpaRepository<Ticket, Integer> {

    @Query(value = "SELECT t FROM Ticket t WHERE t.user.id = :userId")
    List<Ticket> findTicketByUserId(@Param(value = "userId") int id);
}
