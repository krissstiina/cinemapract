package com.cinemaPractic.demo.repositories.impl;

import java.util.List;
import java.util.Optional;

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
    public Film create(Film film) {
        entityManager.persist(film);
        return film;
    }

    @Transactional
    @Override
    public void delete(int id) {
        entityManager.remove(entityManager.find(Film.class, id));
    }

    @Transactional
    @Override
    public Film update(Film film){
        entityManager.persist(film);
        return film;
    }

    @Override
    public List<Film> findAll() {
        return baseFilmRepo.findAll();
    }

    @Override
    public Optional<Film> findById(int id){
        return baseFilmRepo.findById(id);
    }
    @Override
    public List<Film> findAllFilmsSortedByRating(List<String> genres, int amount) {
        return baseFilmRepo.findAllFilmsSortedByRating(genres, amount);
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
//TODO: поправить запрос
    @Query("SELECT DISTINCT f FROM Film f JOIN f.session s JOIN s.ticket t WHERE t.user.id = :userId")
    List<Film> findAllByUserId(@Param("userId") int userId);
}

