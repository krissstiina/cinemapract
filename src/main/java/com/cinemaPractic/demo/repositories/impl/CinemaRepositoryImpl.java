package com.cinemaPractic.demo.repositories.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinemaPractic.demo.entites.Cinema;
import com.cinemaPractic.demo.repositories.BaseRepository;
import com.cinemaPractic.demo.repositories.CinemaRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class CinemaRepositoryImpl extends BaseRepository<Cinema, Integer> implements CinemaRepository{

    @PersistenceContext
    private EntityManager entityManager;

    public CinemaRepositoryImpl(Class<Cinema> entity) {
        super(entity);
    }
}

