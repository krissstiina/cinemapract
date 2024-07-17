package com.cinemaPractic.demo.service;

import java.util.Optional;
import java.util.List;

import com.cinemaPractic.demo.model.CreateTicketDTO;
import com.cinemaPractic.demo.model.TicketDTO;
import com.cinemaPractic.demo.model.UpdateTicketDTO;

public interface TicketService {
    TicketDTO create(CreateTicketDTO ticketDTO);
    Optional<TicketDTO> findById(int id);
    TicketDTO update(UpdateTicketDTO ticketTO);
    List<TicketDTO> findAll();
}
