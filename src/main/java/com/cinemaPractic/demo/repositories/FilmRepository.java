package com.cinemaPractic.demo.repositories;

import java.util.List;

import com.cinemaPractic.demo.entites.Film;

public interface  FilmRepository {
    List<Film> findRecommendedFilmByGenres(String genre);
    void save(Film film);
    void addFilm(Film film);
    void create(Film film);
    Film findFilmById(int id);
    void deleteFilm(int id);
}
