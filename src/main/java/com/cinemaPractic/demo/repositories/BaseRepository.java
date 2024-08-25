package com.cinemaPractic.demo.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.Optional;
import java.util.List;

public abstract class BaseRepository<Entity, Integer> {
    @PersistenceContext
    private EntityManager entityManager;

    private final Class<Entity> entityClass;

    public BaseRepository(Class<Entity> entityClass) {
        this.entityClass = entityClass;
    }

    @Transactional
    public Entity save(Entity entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Transactional
    public Entity create(Entity entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Transactional
    public void update(Entity entity) {
        entityManager.merge(entity);
    }

    @Transactional
    public Optional<Entity> findById(Integer id) {
        return Optional.ofNullable(entityManager.find(entityClass, id));
    }
    
    @Transactional
    public List<Entity> findAll() {
        return entityManager.createQuery(entityClass.getName(), entityClass).getResultList();
    }

    protected EntityManager getEntityManger() {
        return entityManager;
    }

    protected Class<Entity> getEntityClass(){
        return entityClass;
    }
}
