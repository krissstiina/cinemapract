package com.cinemaPractic.demo.repositories.impl;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Session create(Session session) {
        return baseSessionRepo.save(session);
    }


    @Override
    public Session update(Session session){
        return baseSessionRepo.save(session);
    }

    @Override
    public List<Session> findAll() {
        return baseSessionRepo.findAll();
    }

    @Override
    public Optional<Session> findById(int id){
        return baseSessionRepo.findById(id);
    }

    @Override
    public Session findSessionWithAvailableSeats(int id) {
        return baseSessionRepo.findSessionWithAvailableSeats(id);
    }


    @Override
    public List<Session> findSessionsWithAvailableSeatsForFilm(int id) {
        return baseSessionRepo.findSessionsWithAvailableSeatsForFilm(id);
    }
}
@Repository
interface BaseSessionRepo extends JpaRepository<Session, Integer> {

    @Query(value = "SELECT s FROM Session s WHERE s.id = :sessionId")
    Session findSessionWithAvailableSeats(@Param(value = "sessionId") int id);

    @Query(value = "SELECT s FROM Session s WHERE s.film.id = :id")
    List<Session> findSessionsWithAvailableSeatsForFilm(@Param(value = "id") int FilmId);

}
