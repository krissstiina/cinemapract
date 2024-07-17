package com.cinemaPractic.demo.repositories.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cinemaPractic.demo.entites.Cinema;
import com.cinemaPractic.demo.repositories.CinemaRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class CinemaRepositoryDao implements CinemaRepository {

    @Autowired
    private BaseCinemaRepo baseCinemaRepo;


    @Override
    public Cinema create(Cinema cinema) {
        return baseCinemaRepo.save(cinema);
    }

    @Override
    public Cinema update(Cinema cinema){
        return baseCinemaRepo.save(cinema);
    }

    @Override
    public List<Cinema> findAll() {
        return baseCinemaRepo.findAll();
    }

    @Override
    public Optional<Cinema> findById(int id){
        return baseCinemaRepo.findById(id);
    }

}
interface BaseCinemaRepo extends JpaRepository<Cinema, Integer> {}

