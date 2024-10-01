package com.cinemaPractic.demo.repositories.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.cinemaPractic.demo.entites.Session;
import com.cinemaPractic.demo.repositories.SessionRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class SessionRepositoryImpl extends BaseRepositoryImpl<Session> implements SessionRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public SessionRepositoryImpl() {
        super(Session.class);
    }

    @Override
    public Session findSessionWithAvailableSeats(int id) {
        return entityManager.createQuery("SELECT s FROM Session s WHERE s.id = :sessionId", Session.class)
                .setParameter("sessionId", id)
                .getSingleResult();
    }

    @Override
    public List<Session> findSessionsWithAvailableSeatsForFilm(int filmId) {
        return entityManager.createQuery("SELECT s FROM Session s WHERE s.film.id = :id", Session.class)
                .setParameter("id", filmId)
                .getResultList();
    }

    @Override
    public Optional<Session> findById(int sessionId) {
        return Optional.ofNullable(entityManager.find(Session.class, sessionId));
    }

    @Transactional
    @Override
    public void update(Session session){
        entityManager.persist(session);
    }
}