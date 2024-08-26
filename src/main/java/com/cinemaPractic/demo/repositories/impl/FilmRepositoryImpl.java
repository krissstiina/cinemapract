package com.cinemaPractic.demo.repositories.impl;

import java.util.List;
import org.springframework.stereotype.Repository;

import com.cinemaPractic.demo.entites.Cinema;
import com.cinemaPractic.demo.entites.Film;
import com.cinemaPractic.demo.repositories.FilmRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class FilmRepositoryImpl extends BaseRepositoryImpl<Film> implements FilmRepository  {
    
    @PersistenceContext
    private EntityManager entityManager;

    public FilmRepositoryImpl() {
        super(Film.class);
    }

    @Override
    public List<Film> findAllFilmsSortedByRating(List<String> genres, int amount) {
        return entityManager.createQuery("SELECT f FROM Film f WHERE f.genre IN :genres ORDER BY f.rating DESC LIMIT :amount", Film.class)
                .setParameter("genres", genres)
                .setParameter("amount", amount)
                .getResultList();
    }

    @Override
    public List<Film> findAllByUserId(int userId) {
        return entityManager.createQuery("SELECT f FROM Film AS f JOIN Session AS s ON s.film = f JOIN Ticket AS t ON t.session = s JOIN t.user AS u WHERE u.id = :userId", Film.class)
                .setParameter("userId", userId)
                .getResultList();
    }

    @Override
    public List<Film> findMostPopularFilms() {
        return entityManager.createQuery("SELECT f, count(t) AS top FROM Film AS f JOIN Session as s ON s.film = f JOIN Ticket AS t ON t.session = s GROUP BY f.id ORDER BY top DESC", Film.class)
                .getResultList();
    }

}