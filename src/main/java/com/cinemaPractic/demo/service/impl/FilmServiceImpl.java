package com.cinemaPractic.demo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinemaPractic.demo.entites.Film;
import com.cinemaPractic.demo.model.CreateFilmDTO;
import com.cinemaPractic.demo.model.FilmDTO;
import com.cinemaPractic.demo.model.UpdateFilmDTO;
import com.cinemaPractic.demo.repositories.FilmRepository;
import com.cinemaPractic.demo.service.FilmService;

@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public FilmDTO create(CreateFilmDTO filmCreateDto) {
        Film film = mapper.map(filmCreateDto, Film.class);
        filmRepository.create(film);
        return mapper.map(film, FilmDTO.class);
    }

    @Override
    public FilmDTO findById(int id) {
        Optional<Film> film = filmRepository.findById(id);


        return mapper.map(film, FilmDTO.class);
    }

    @Override
    public FilmDTO update(UpdateFilmDTO filmUpdateDTO) {
        Optional<Film> film = filmRepository.findById(filmUpdateDTO.getId());
        film.get().setName(filmUpdateDTO.getName());
        filmRepository.update(film.get());
        return mapper.map(film,FilmDTO.class);
    }

    @Override
    public List<FilmDTO> getRecommendations(int userId) {
        List<Film> films = filmRepository.findAllByUserId(userId);
        
        Map<String, Integer> genreRepetitions = new HashMap<>();

        for (var film : films) {
            if (!genreRepetitions.containsKey(film.getGenre())) {
                genreRepetitions.put(film.getGenre(), 0);
            }

            genreRepetitions.put(film.getGenre(), genreRepetitions.get(film.getGenre()) + 1);
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

        return recommendedFilms.stream().map((film) -> mapper.map(film, FilmDTO.class)).toList();
    }

    @Override
    public List<Film> getMostPopularFilms() {
        return filmRepository.findMostPopularFilms();
    }
}