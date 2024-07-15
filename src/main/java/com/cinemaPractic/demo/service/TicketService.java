package com.cinemaPractic.demo.service;

import com.cinemaPractic.demo.entites.Ticket;

public interface TicketService {
    void create(Ticket ticket);
    void delete(int id);
}
