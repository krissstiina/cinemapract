package com.cinemaPractic.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.cinemaPractic.demo.entites.Cinema;
import com.cinemaPractic.demo.entites.Film;
import com.cinemaPractic.demo.repositories.generic.CreateRepository;
import com.cinemaPractic.demo.repositories.generic.ReadRepository;
import com.cinemaPractic.demo.repositories.generic.UpdateRepository;

@Repository
public interface FilmRepository extends ReadRepository<Film>, CreateRepository<Film>, UpdateRepository<Film> {
    List<Film> findAllFilmsSortedByRating(List<String> preferableGenres, int amount);
    List<Film> findAllByUserId(int id);
    List<Film> findMostPopularFilms();
}
