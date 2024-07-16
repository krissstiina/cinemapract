package com.cinemaPractic.demo.repositories;


import java.util.List;
import java.util.Optional;

import com.cinemaPractic.demo.entites.Session;

public interface SessionRepository {
    Session create(Session session);
    Session findSessionWithAvailableSeats(int id);
    List<Session> findSessionsWithAvailableSeatsForFilm(int id);
    Optional<Session> findById(int id);
    void save(Session session);
    void delete(int id);
    Session update(Session session);
    List<Session> findAll();
}
