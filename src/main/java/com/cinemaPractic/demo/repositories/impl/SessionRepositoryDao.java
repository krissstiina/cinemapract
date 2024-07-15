package com.cinemaPractic.demo.repositories.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cinemaPractic.demo.entites.Session;
import com.cinemaPractic.demo.repositories.SessionRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class SessionRepositoryDao implements SessionRepository {
    
    @Autowired
    private BaseSessionRepo baseSessionRepo;

    @PersistenceContext
    private EntityManager entityManager;


    @Transactional
    @Override
    public void createSession(Session session) {
        entityManager.persist(session);
    }


    @Override
    public Session findSessionWithAvailableSeats(int id) {
        return baseSessionRepo.findSessionWithAvailableSeats(id);
    }

    @Override
    public int bookSeat(int id) {
        return baseSessionRepo.bookSeat(id);
    }

    @Override
    public List<Session> findSessionsWithAvailableSeatsForFilm(int id) {
        return baseSessionRepo.findSessionsWithAvailableSeatsForFilm(id);
    }
}

interface BaseSessionRepo extends JpaRepository<Session, Integer> {

    @Query(value = "SELECT s FROM Session s WHERE s.id = :sessionId AND s.availableSeats > 0")
    Session findSessionWithAvailableSeats(@Param(value = "sessionId") int id);

    @Query(value = "SELECT s FROM Session s WHERE s.film.id = :id AND s.availableSeats > 0")
    List<Session> findSessionsWithAvailableSeatsForFilm(@Param(value = "id") int FilmId);

    @Query(value = "UPDATE Session s SET s.availableSeats = s.availableSeats - 1 WHERE s.id = :id AND s.availableSeats > 0")
    int bookSeat(@Param(value = "id") int id);
}
