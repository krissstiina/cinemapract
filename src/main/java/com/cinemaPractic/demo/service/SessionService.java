package com.cinemaPractic.demo.service;

import java.util.List;
import java.util.Optional;

import com.cinemaPractic.demo.entites.Session;
import com.cinemaPractic.demo.model.CreateSessionDTO;
import com.cinemaPractic.demo.model.SessionDTO;
import com.cinemaPractic.demo.model.UpdateSessionDTO;

public interface SessionService {
    SessionDTO create(CreateSessionDTO sessionDTO);
    SessionDTO bookSeat(int sessionId);
    void delete(int id);
    Optional<SessionDTO> findById(int id);
    SessionDTO update(UpdateSessionDTO sessionDTO);
    List<SessionDTO> findAll();
    void save(Session session);
}
