package com.cinemaPractic.demo.controller;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinemaPractic.demo.model.CinemaDTO;
import com.cinemaPractic.demo.model.CreateCinemaDTO;
import com.cinemaPractic.demo.model.CreateTicketDTO;
import com.cinemaPractic.demo.model.TicketDTO;
import com.cinemaPractic.demo.model.UpdateCinemaDTO;
import com.cinemaPractic.demo.model.UpdateTicketDTO;
import com.cinemaPractic.demo.service.TicketService;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @GetMapping("/{id}")
    public TicketDTO getById(@PathVariable int id){
        return ticketService.findById(id);
    }

    @PostMapping("")
    public TicketDTO create(@RequestBody CreateTicketDTO createTicketDTO){
        return ticketService.create(createTicketDTO);
    }

}
