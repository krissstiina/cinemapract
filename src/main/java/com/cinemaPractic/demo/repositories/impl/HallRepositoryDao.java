package com.cinemaPractic.demo.repositories.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cinemaPractic.demo.entites.Hall;
import com.cinemaPractic.demo.repositories.HallRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
@Repository
public class HallRepositoryDao implements HallRepository {
    
    @Autowired
    private BaseHallRepo baseHallRepo;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public Hall create(Hall hall) {
        return baseHallRepo.save(hall);
    }

    @Transactional
    @Override
    public Hall update(Hall hall){
        return baseHallRepo.save(hall);
    }

    @Override
    public List<Hall> findAll() {
        return baseHallRepo.findAll();
    }

    @Override
    public Optional<Hall> findById(int id){
        return baseHallRepo.findById(id);
    }

}

interface BaseHallRepo extends JpaRepository<Hall, Integer> {}

