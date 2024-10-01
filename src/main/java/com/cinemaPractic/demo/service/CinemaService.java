package com.cinemaPractic.demo.service;

import com.cinemaPractic.demo.model.CinemaDTO;
import com.cinemaPractic.demo.model.CreateCinemaDTO;
import com.cinemaPractic.demo.model.UpdateCinemaDTO;


public interface  CinemaService {
    CinemaDTO findById(int id);
    CinemaDTO update(UpdateCinemaDTO cinemaUpdateDTO);
    CinemaDTO create(CreateCinemaDTO cinemaCreateDto);
}
