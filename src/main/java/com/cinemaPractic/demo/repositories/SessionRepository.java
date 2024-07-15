package com.cinemaPractic.demo.repositories;


import java.util.List;

import com.cinemaPractic.demo.entites.Session;

public interface SessionRepository {
    void createSession(Session session);
    Session findSessionWithAvailableSeats(int id);
    List<Session> findSessionsWithAvailableSeatsForFilm(int id);
    int bookSeat(int id);
}
