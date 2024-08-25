package com.cinemaPractic.demo.service;


import java.util.List;
import java.util.Optional;

import com.cinemaPractic.demo.model.CinemaDTO;
import com.cinemaPractic.demo.model.CreateCinemaDTO;
import com.cinemaPractic.demo.model.UpdateCinemaDTO;


public interface  CinemaService {
    void addCinema(CinemaDTO cinema);
}
