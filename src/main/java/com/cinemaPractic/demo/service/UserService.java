package com.cinemaPractic.demo.service;

import com.cinemaPractic.demo.entites.User;

public interface UserService {
    Integer getPoints(int id);
    void addPoint(int id);
    boolean redeemPoints(int id, Integer points);
    Integer calculateRedeemAmount(Integer points);
    User findUserById(int id);
    void deleteUser(int id);
    void create(User user);
}
