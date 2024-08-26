package com.cinemaPractic.demo.service;

import com.cinemaPractic.demo.model.CreateSessionDTO;
import com.cinemaPractic.demo.model.SessionDTO;

public interface SessionService {
    SessionDTO bookSeat(int sessionId);
    SessionDTO create(CreateSessionDTO sessionCreateDto);
    SessionDTO findById(int id);

}
