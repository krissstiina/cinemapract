package com.cinemaPractic.demo.repositories.impl;

import org.springframework.stereotype.Repository;

import com.cinemaPractic.demo.entites.Cinema;
import com.cinemaPractic.demo.repositories.CinemaRepository;
import jakarta.persistence.Entity;

@Repository
public class CinemaRepositoryImpl extends BaseRepositoryImpl<Cinema> implements CinemaRepository{

    public CinemaRepositoryImpl() {
        super(Cinema.class);
    }
}

