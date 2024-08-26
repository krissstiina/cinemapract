package com.cinemaPractic.demo.repositories.impl;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import com.cinemaPractic.demo.entites.BaseEntity;
import com.cinemaPractic.demo.repositories.generic.CreateRepository;
import com.cinemaPractic.demo.repositories.generic.ReadRepository;
import com.cinemaPractic.demo.repositories.generic.UpdateRepository;

import java.util.Optional;
import java.util.List;

public class BaseRepositoryImpl<T extends BaseEntity> implements ReadRepository<T>, CreateRepository<T>, UpdateRepository<T> {
    @PersistenceContext
    private EntityManager entityManager;

    private final Class<T> entityClass;

    public BaseRepositoryImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Transactional
    @Override
    public T save(T entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Transactional
    @Override
    public T create(T entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Transactional
    @Override
    public void update(T entity) {
        entityManager.merge(entity);
    }

    @Transactional
    @Override
    public Optional<T> findById(Integer id) {
        return Optional.ofNullable(entityManager.find(entityClass, id));
    }
    
    @Transactional
    @Override
    public List<T> findAll() {
        return entityManager.createQuery(entityClass.getName(), entityClass).getResultList();
    }

    protected EntityManager getEntityManger() {
        return entityManager;
    }

    protected Class<T> getEntityClass(){
        return entityClass;
    }
}
