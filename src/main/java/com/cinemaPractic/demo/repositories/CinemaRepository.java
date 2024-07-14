package com.cinemaPractic.demo.repositories;

import org.springframework.stereotype.Repository;

import com.cinemaPractic.demo.entites.Cinema;

@Repository
public interface CinemaRepository {

    void save(Cinema cinema);
    void addCinema(Cinema cinema);
}
