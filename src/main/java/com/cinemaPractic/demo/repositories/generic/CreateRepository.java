package com.cinemaPractic.demo.repositories.generic;

import jakarta.persistence.Entity;

public interface CreateRepository<T> {
    T save(T entity);
    T create(T entity);
}
