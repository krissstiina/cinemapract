package com.cinemaPractic.demo.repositories;

import com.cinemaPractic.demo.entites.Hall;

public interface HallRepository {
    void createHall(Hall hall);
    void deleteHall(int id);
}
