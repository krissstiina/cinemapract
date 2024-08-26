package com.cinemaPractic.demo.repositories.generic;

import jakarta.persistence.Entity;
import java.util.Optional;

import java.util.List;

public interface ReadRepository<T> {
    Optional<T> findById(Integer id);
    List<T> findAll();
}
