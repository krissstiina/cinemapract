package com.cinemaPractic.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.cinemaPractic.demo.entites.User;

@Repository
public interface UserRepository {
    User create(User user);
    User update(User user);
    List<User> findAll();
    Optional<User> findById(int id);
}
