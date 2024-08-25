package com.cinemaPractic.demo.repositories.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinemaPractic.demo.entites.Hall;
import com.cinemaPractic.demo.repositories.BaseRepository;
import com.cinemaPractic.demo.repositories.HallRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class HallRepositoryImpl extends BaseRepository<Hall, Integer> implements HallRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public HallRepositoryImpl(Class<Hall> entity) {
        super(entity);
    }
}