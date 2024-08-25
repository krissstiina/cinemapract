package com.cinemaPractic.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.cinemaPractic.demo.entites.Session;

@Repository
public interface SessionRepository {
    Session findSessionWithAvailableSeats(int id);
    List<Session> findSessionsWithAvailableSeatsForFilm(int id);
    Optional<Session> findById(int sessionId);
    void update(Session session);
}
