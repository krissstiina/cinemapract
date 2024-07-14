package com.cinemaPractic.demo.repositories.impl;

import org.springframework.transaction.annotation.Transactional;

import com.cinemaPractic.demo.entites.Hall;
import com.cinemaPractic.demo.repositories.HallRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class HallRepositoryDao implements HallRepository {
    
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void save(Hall hall) {
        entityManager.persist(hall);
    }

    @Transactional
    @Override
    public void addHall(Hall hall) {
        entityManager.persist(hall);
    }

}
