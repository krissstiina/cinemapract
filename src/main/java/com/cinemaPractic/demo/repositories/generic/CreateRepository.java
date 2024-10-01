package com.cinemaPractic.demo.repositories.generic;
public interface CreateRepository<T> {
    T save(T entity);
    T create(T entity);
}
