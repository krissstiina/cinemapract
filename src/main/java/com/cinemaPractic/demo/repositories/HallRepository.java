package com.cinemaPractic.demo.repositories;

import java.util.List;
import java.util.Optional;

import com.cinemaPractic.demo.entites.Hall;

public interface HallRepository {
    Hall create(Hall hall);
    void delete(int id);
    Hall update(Hall hall);
    List<Hall> findAll();
    Optional<Hall> findById(int id);
}
