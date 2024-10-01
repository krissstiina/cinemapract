package com.cinemaPractic.demo.service;

import java.util.Optional;

import com.cinemaPractic.demo.model.CreateSessionDTO;
import com.cinemaPractic.demo.model.SessionDTO;

public interface SessionService {
    SessionDTO bookSeat(int sessionId);
    SessionDTO create(CreateSessionDTO sessionCreateDto);
    Optional<SessionDTO> findById(int id);

}
