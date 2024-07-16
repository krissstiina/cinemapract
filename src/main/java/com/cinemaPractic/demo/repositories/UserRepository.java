package com.cinemaPractic.demo.repositories;

import java.util.List;
import java.util.Optional;

import com.cinemaPractic.demo.entites.User;

public interface UserRepository {
    User create(User user);
    void delete(int id);
    User update(User user);
    List<User> findAll();
    Optional<User> findById(int id);
//     Integer findPointsByUserId(int id);
//     int addPoint(int id);
//     int deductPoints(int id, int points);
}
