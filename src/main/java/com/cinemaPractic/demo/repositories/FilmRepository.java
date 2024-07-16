package com.cinemaPractic.demo.repositories;

import java.util.List;
import java.util.Optional;

import com.cinemaPractic.demo.entites.Film;

public interface FilmRepository {
    List<Film> findAllFilmsSortedByRating(List<String> preferableGenres, int amount);
    List<Film> findAllByUserId(int id);
    List<Film> findAll();
    Film create(Film film);
    void delete(int id);
    Film update(Film film);
    Optional<Film> findById(int id);
}
