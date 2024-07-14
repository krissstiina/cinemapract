package com.cinemaPractic.demo.repositories;

import com.cinemaPractic.demo.entites.Hall;

public interface HallRepository {
    void save(Hall hall);
    void addHall(Hall hall);
}
