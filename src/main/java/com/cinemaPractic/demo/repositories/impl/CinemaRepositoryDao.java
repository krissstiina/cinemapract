package com.cinemaPractic.demo.repositories.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cinemaPractic.demo.entites.Cinema;
import com.cinemaPractic.demo.repositories.CinemaRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class CinemaRepositoryDao implements CinemaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void save(Cinema cinema) {
        entityManager.persist(cinema);
    }

    @Transactional
    @Override
    public void addCinema(Cinema cinema) {
        entityManager.persist(cinema);
    }
}

