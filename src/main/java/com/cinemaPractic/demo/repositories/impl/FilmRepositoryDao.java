package com.cinemaPractic.demo.repositories.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cinemaPractic.demo.entites.Film;
import com.cinemaPractic.demo.repositories.FilmRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class FilmRepositoryDao implements FilmRepository  {

    @Autowired
    private BaseFilmRepo baseFilmRepo;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void update(Film film){
        entityManager.persist(film);
    }
    
    @Transactional
    @Override
    public void create(Film film){
        entityManager.persist(film);
    }

    @Transactional
    @Override
    public void deleteFilm(int id) {
        entityManager.remove(entityManager.find(Film.class, id));
    }

    @Override
    public List<Film> findAllFilmsSortedByRating(List<String> preferableGenres, int amount) {
        return baseFilmRepo.findAllFilmsSortedByRating(preferableGenres, amount);
    }

    @Override
    public Film findFilmById(int id) {
        return entityManager.find(Film.class, id);
    }

    @Override
    public List<Film> findAll() {
        return baseFilmRepo.findAll();
    }

    @Override
    public List<Film> findAllByUserId(int id) {
        return baseFilmRepo.findAllByUserId(id);
    }
}

interface BaseFilmRepo extends JpaRepository<Film, Integer> {

    @Query(value = "SELECT f FROM Film f WHERE f.genre IN :genres ORDER BY f.rating DESC LIMIT :amount")
    List<Film> findAllFilmsSortedByRating(
        @Param("genres") List<String> genres,
        @Param("amount") int amount
    );

    @Query("SELECT DISTINCT f FROM Film f JOIN f.session s JOIN s.ticket t WHERE t.user.id = :userId")
    List<Film> findAllByUserId(@Param("userId") int id);
}

