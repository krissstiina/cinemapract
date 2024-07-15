package com.cinemaPractic.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.cinemaPractic.demo.entites.User;
import com.cinemaPractic.demo.repositories.UserRepository;
import com.cinemaPractic.demo.service.UserService;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUserById(int id) {
        return userRepository.findUserById(id);
    }

    @Transactional
    @Override
    public void create(User user) {
        userRepository.create(user);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteUser(id);
    }

    @Override
    public void addPoint(int id) {
        userRepository.addPoint(id);
    }

    @Override
    public Integer getPoints(int id) {
        return userRepository.findPointsByUserId(id);
    }

    @Override
    public boolean redeemPoints(int id, Integer points) {
        int updatedPoints = userRepository.deductPoints(id, points);
        return updatedPoints > 0;
    }

    @Override
    public Integer calculateRedeemAmount(Integer points) {
        return points * 10; // 1 балл = 10 рублей
    }

}
