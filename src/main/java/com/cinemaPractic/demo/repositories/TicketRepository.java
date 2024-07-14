package com.cinemaPractic.demo.repositories;

import com.cinemaPractic.demo.entites.Ticket;

public interface TicketRepository {

    void addTicket(Ticket ticket);
    void create(Ticket ticket);
    void delete(int id);

}
