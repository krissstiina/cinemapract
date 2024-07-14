package com.cinemaPractic.demo.repositories;

import com.cinemaPractic.demo.entites.Session;

public interface SessionRepository {
    void save(Session session);
    void addHall(Session session);
    Session findSessionWithAvailableSeats(int id);
    int bookSeat(int id);
}
