package com.cinemaPractic.demo.repositories;

import java.util.List;
import java.util.Optional;

import com.cinemaPractic.demo.entites.Ticket;

public interface TicketRepository {

    Ticket create(Ticket ticket);
    void delete(int id);
    Ticket update(Ticket ticket);
    Optional<Ticket> findById(int id);
    List<Ticket> findAll();
    Ticket findTicketByUserAndSession(int userId, int sessionId);

}
