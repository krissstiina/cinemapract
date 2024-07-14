package com.cinemaPractic.demo.repositories.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.cinemaPractic.demo.entites.Film;
import com.cinemaPractic.demo.repositories.FilmRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


public class FilmRepositoryDao implements FilmRepository  {

    @Autowired
    private BaseFilmRepo baseFilmRepo;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void save(Film film) {
        entityManager.persist(film);
    }

    @Transactional
    @Override
    public void addFilm(Film film) {
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
    public List<Film> findRecommendedFilmByGenres(String genre) {
        return baseFilmRepo.findRecommendedFilmByGenres(genre);
    }

    @Override
    public Film findFilmById(int id) {
        return entityManager.find(Film.class, id);
    }
}

interface BaseFilmRepo extends JpaRepository<Film, Integer> {

    @Query(value = "SELECT f FROM Film f WHERE f.genre IN :genre ORDER BY f.viewCount DESC")
    List<Film> findRecommendedFilmByGenres(@Param(value = "genre") String genre);

}

