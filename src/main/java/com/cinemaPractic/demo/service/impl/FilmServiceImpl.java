package com.cinemaPractic.demo.service.impl;


import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinemaPractic.demo.entites.Film;
import com.cinemaPractic.demo.entites.User;
import com.cinemaPractic.demo.repositories.FilmRepository;
import com.cinemaPractic.demo.service.FilmService;

@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    private FilmRepository filmRepository;

    @Override
    public void createFilm(Film film) {
        filmRepository.create(film);
    }

    @Override
    public void deleteFilm(int id) {
        filmRepository.deleteFilm(id);
    }

    @Override
    public Film findFilmById(int id) {
        return filmRepository.findFilmById(id);
    }

    public List<Film> getRecommendations(User user) {
        List<Film> films = filmRepository.findAllByUserId(user.getId());
        
        Map<String, Integer> genreRepetitions = new HashMap<>();

        for (var film : films) {
            if (!genreRepetitions.containsKey(film.getGenre())) {
                genreRepetitions.put(film.getGenre(), 0);
            }

            genreRepetitions.put(film.getGenre(), genreRepetitions.get(film.getGenre()) + 1);
        }

        // TODO: Remove
        for (var entry : genreRepetitions.entrySet()) {
            System.out.println(entry.getValue() + " " + entry.getKey());
        }

        List<String> popularGenresSorted = genreRepetitions.entrySet()
            .stream()
            .sorted((left, right) -> right.getValue() - left.getValue())
            .map((entry) -> entry.getKey())
            .toList();

        List<String> mostPopularGenres = popularGenresSorted.subList(
            0,
            Math.min(3, popularGenresSorted.size())
        );

        int recommendedFilmsCount = 5;
        List<Film> recommendedFilms = filmRepository.findAllFilmsSortedByRating(mostPopularGenres, recommendedFilmsCount);

        return recommendedFilms;
    }
}
