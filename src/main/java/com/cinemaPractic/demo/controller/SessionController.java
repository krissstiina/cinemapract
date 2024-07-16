package com.cinemaPractic.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinemaPractic.demo.entites.Session;
import com.cinemaPractic.demo.model.CreateSessionDTO;
import com.cinemaPractic.demo.model.SessionDTO;
import com.cinemaPractic.demo.model.UpdateSessionDTO;
import com.cinemaPractic.demo.service.SessionService;

@RestController
@RequestMapping("/api/session")
public class SessionController {
    @Autowired
    private SessionService sessionService;

    @GetMapping("/{id}")
    public SessionDTO getById(@PathVariable int id) {
        Optional<SessionDTO> sessionDTO = sessionService.findById(id);
        return sessionDTO.get();
    }

    @GetMapping("")
    public List<SessionDTO> getAll(){
        return sessionService.findAll();
    }

    @PostMapping("")
    public SessionDTO create(@RequestBody CreateSessionDTO createSessionDTO){
        return sessionService.create(createSessionDTO);
    }

    @PatchMapping("")
    public SessionDTO update(@RequestBody UpdateSessionDTO updateSessionDTO){
        return sessionService.update(updateSessionDTO);
    }
    
    @PostMapping("/{sessionId}/book")
    public ResponseEntity<Session> bookSeat(@PathVariable("sessionId") int sessionId) {
        Session bookedSession = sessionService.bookSeat(sessionId);

        if (bookedSession != null) {
            return ResponseEntity.ok(bookedSession);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}