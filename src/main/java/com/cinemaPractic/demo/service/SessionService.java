package com.cinemaPractic.demo.service;

import com.cinemaPractic.demo.entites.Session;

public interface SessionService {
    void createSession(Session session);
    Session findSessionWithAvailableSeats(int id);
    Session bookSeat(int id);
    Session findAlternativeSession(int id);
}
