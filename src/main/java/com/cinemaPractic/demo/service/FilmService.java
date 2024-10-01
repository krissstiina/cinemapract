package com.cinemaPractic.demo.service;

import java.util.List;

import com.cinemaPractic.demo.entites.Film;
import com.cinemaPractic.demo.model.CreateFilmDTO;
import com.cinemaPractic.demo.model.FilmDTO;
import com.cinemaPractic.demo.model.UpdateFilmDTO;

public interface FilmService {
    List<FilmDTO> getRecommendations(int userId);
    FilmDTO findById(int id);
    List<Film> getMostPopularFilms();
    FilmDTO update(UpdateFilmDTO filmUpdateDTO);
    FilmDTO create(CreateFilmDTO filmCreateDto);

}
