package com.cinemaPractic.demo.service;

import java.util.List;
import java.util.Optional;

import com.cinemaPractic.demo.model.CreateFilmDTO;
import com.cinemaPractic.demo.model.FilmDTO;
import com.cinemaPractic.demo.model.UpdateFilmDTO;

public interface FilmService {
    FilmDTO create(CreateFilmDTO filmDTO);
    void delete(int id);
    List<FilmDTO> findAll();
    Optional<FilmDTO> findById(int id);
    List<FilmDTO> getRecommendations(int userId);
    FilmDTO update(UpdateFilmDTO filmDTO);
}
