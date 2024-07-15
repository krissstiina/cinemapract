package com.cinemaPractic.demo.repositories.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cinemaPractic.demo.entites.Hall;
import com.cinemaPractic.demo.repositories.HallRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
@Repository
public class HallRepositoryDao implements HallRepository {
    
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void deleteHall(int id) {
        entityManager.remove(entityManager.find(Hall.class, id));
    }

    @Transactional
    @Override
    public void createHall(Hall hall) {
        entityManager.persist(hall);
    }
}
