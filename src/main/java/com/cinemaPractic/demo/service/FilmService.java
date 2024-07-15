package com.cinemaPractic.demo.service;

import com.cinemaPractic.demo.entites.Film;

public interface FilmService {
    void createFilm(Film film);
    void deleteFilm(int id);
    Film findFilmById(int id);
}
