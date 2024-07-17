package com.cinemaPractic.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.cinemaPractic.demo.entites.Film;
@Repository
public interface FilmRepository {
    List<Film> findAllFilmsSortedByRating(List<String> preferableGenres, int amount);
    List<Film> findAllByUserId(int id);
    List<Film> findAll();
    Film create(Film film);
    Film update(Film film);
    Optional<Film> findById(int id);
    List<Film> findMostPopularFilms();
}
