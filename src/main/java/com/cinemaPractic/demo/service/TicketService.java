package com.cinemaPractic.demo.service;
import java.util.Optional;

import com.cinemaPractic.demo.model.CreateTicketDTO;
import com.cinemaPractic.demo.model.TicketDTO;

public interface TicketService {
    Optional<TicketDTO> findById(int id);
    TicketDTO create(CreateTicketDTO ticketCreateDto);
}
