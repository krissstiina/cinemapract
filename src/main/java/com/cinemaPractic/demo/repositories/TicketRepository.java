package com.cinemaPractic.demo.repositories;

import java.util.List;

import com.cinemaPractic.demo.entites.Ticket;

public interface TicketRepository {

    List<Ticket> findTicketByUserId(int id);
    void create(Ticket ticket);
    void delete(int id);
    void findByUserId(int id);

}
