package com.cinemaPractic.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.cinemaPractic.demo.entites.Ticket;

@Repository
public interface TicketRepository {

    Ticket create(Ticket ticket);
    void delete(int id);
    Ticket update(Ticket ticket);
    Optional<Ticket> findById(int id);
    List<Ticket> findAll();
    // List<Ticket> findTicketsByUser(int userId);
}
