package com.cinemaPractic.demo.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinemaPractic.demo.entites.Cinema;
import com.cinemaPractic.demo.exception.CinemaNotFoundException;
import com.cinemaPractic.demo.model.CinemaDTO;
import com.cinemaPractic.demo.repositories.impl.CinemaRepositoryImpl;
import com.cinemaPractic.demo.service.CinemaService;

@Service
public class CinemaServiceImpl extends CinemaNotFoundException implements CinemaService {
    @Autowired
    private CinemaRepositoryImpl cinemaRepository;

    private ModelMapper modelMapper = new ModelMapper();

    
    @Override
    public void addCinema(CinemaDTO cinema) {
        Cinema cinemaToAdd = modelMapper.map(cinema, Cinema.class);
        cinemaRepository.save(cinemaToAdd);
    }
}
