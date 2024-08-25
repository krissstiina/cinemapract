package com.cinemaPractic.demo.service;

import com.cinemaPractic.demo.model.SessionDTO;

public interface SessionService {
    SessionDTO bookSeat(int sessionId);
}
