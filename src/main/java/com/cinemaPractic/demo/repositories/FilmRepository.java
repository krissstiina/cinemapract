package com.cinemaPractic.demo.repositories;

import java.util.List;

import com.cinemaPractic.demo.entites.Film;

public interface FilmRepository {
    List<Film> findAllFilmsSortedByRating(List<String> preferableGenres, int amount);
    List<Film> findAllByUserId(int id);
    List<Film> findAll();
    void create(Film film);
    void update(Film film);
    Film findFilmById(int id);
    void deleteFilm(int id);
}
