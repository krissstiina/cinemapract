package com.cinemaPractic.demo.repositories;

import com.cinemaPractic.demo.entites.User;

public interface UserRepository {
    Integer findPointsByUserId(int id);
    int addPoint(int id);
    int deductPoints(int id, int points);
    User findUserById(int id);
    void deleteUser(int id);
}
