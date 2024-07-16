package com.cinemaPractic.demo.repositories;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.cinemaPractic.demo.entites.Cinema;

@Repository
public interface CinemaRepository {

    Cinema create(Cinema cinema);
    void delete(int id);
    Cinema update(Cinema cinema);
    List<Cinema> findAll();
    Optional<Cinema> findById(int id);
}
