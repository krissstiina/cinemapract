package com.cinemaPractic.demo.repositories.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cinemaPractic.demo.entites.User;
import com.cinemaPractic.demo.repositories.UserRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

public class UserRepositoryDao implements UserRepository{
    @Autowired
    private BaseUserRepo baseUserRepo;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Integer findPointsByUserId(int id) {
        return baseUserRepo.findPointsByUserId(id);
    }

    @Override
    public int addPoint(int id) {
        return baseUserRepo.addPoint(id);
    }

    @Override
    public int deductPoints(int id, int points) {
        return baseUserRepo.deductPoints(id, points);
    }

    @Override
    public User findUserById(int id) {
        return entityManager.find(User.class, id);
    }

    @Transactional
    @Override
    public void deleteUser(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

}

interface BaseUserRepo extends JpaRepository<User, Integer> {

    @Query(value = "SELECT u.points FROM User u WHERE u.id = :userId")
    Integer findPointsByUserId(@Param(value = "id") int id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE User u SET u.points = u.points + 1 WHERE u.id = :userId")
    int addPoint(@Param(value = "id") int id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE User u SET u.points = u.points - :points WHERE u.id = :userId AND u.points >= :points")
    int deductPoints(@Param(value = "id") int id, @Param(value = "points") Integer points);
}

