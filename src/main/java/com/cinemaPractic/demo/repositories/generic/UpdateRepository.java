package com.cinemaPractic.demo.repositories.generic;

import jakarta.persistence.Entity;

public interface UpdateRepository<T> {
    void update(T entity);
}
