package com.cinemaPractic.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.cinemaPractic.demo.entites.Hall;

@Repository
public interface HallRepository {
    Hall create(Hall hall);
    Hall update(Hall hall);
    List<Hall> findAll();
    Optional<Hall> findById(int id);
}
