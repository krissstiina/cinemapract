package com.cinemaPractic.demo.service;

import com.cinemaPractic.demo.model.CreateTicketDTO;
import com.cinemaPractic.demo.model.TicketDTO;

public interface TicketService {
    TicketDTO findById(int id);
    TicketDTO create(CreateTicketDTO ticketCreateDto);
}
