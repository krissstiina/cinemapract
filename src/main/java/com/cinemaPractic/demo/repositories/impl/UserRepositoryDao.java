package com.cinemaPractic.demo.repositories.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinemaPractic.demo.entites.User;
import com.cinemaPractic.demo.repositories.UserRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
@Repository
public class UserRepositoryDao implements UserRepository{
    @Autowired
    private BaseUserRepo baseUserRepo;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public User create(User user) {
        entityManager.persist(user);
        return user;
    }

    @Transactional
    @Override
    public void delete(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Transactional
    @Override
    public User update(User user){
        entityManager.persist(user);
        return user;
    }

    @Override
    public List<User> findAll() {
        return baseUserRepo.findAll();
    }

    @Override
    public Optional<User> findById(int id){
        return baseUserRepo.findById(id);
    }
    
}

interface BaseUserRepo extends JpaRepository<User, Integer> {

}

