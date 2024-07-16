package com.cinemaPractic.demo.service;


import java.util.List;
import java.util.Optional;

import com.cinemaPractic.demo.model.CinemaDTO;
import com.cinemaPractic.demo.model.CreateCinemaDTO;
import com.cinemaPractic.demo.model.UpdateCinemaDTO;


public interface  CinemaService {
    CinemaDTO create(CreateCinemaDTO cinemaDTO);
    Optional<CinemaDTO> findById(int id);
    void delete(int id);
    CinemaDTO update(UpdateCinemaDTO cinemaDTO);
    List<CinemaDTO> findAll();
}
