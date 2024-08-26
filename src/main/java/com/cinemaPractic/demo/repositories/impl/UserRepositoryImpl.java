package com.cinemaPractic.demo.repositories.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinemaPractic.demo.entites.User;
import com.cinemaPractic.demo.repositories.UserRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class UserRepositoryImpl extends BaseRepositoryImpl<User> implements UserRepository{

    public UserRepositoryImpl() {
        super(User.class);
    }
}