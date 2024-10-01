package com.cinemaPractic.demo.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinemaPractic.demo.entites.Cinema;
import com.cinemaPractic.demo.entites.Hall;
import com.cinemaPractic.demo.exception.CinemaNotFoundException;
import com.cinemaPractic.demo.model.CinemaDTO;
import com.cinemaPractic.demo.model.CreateCinemaDTO;
import com.cinemaPractic.demo.model.HallDTO;
import com.cinemaPractic.demo.repositories.CinemaRepository;
import com.cinemaPractic.demo.repositories.impl.CinemaRepositoryImpl;
import com.cinemaPractic.demo.service.CinemaService;
import com.cinemaPractic.demo.exception.CinemaNotFoundException;
import com.cinemaPractic.demo.model.UpdateCinemaDTO;

@Service
public class CinemaServiceImpl extends CinemaNotFoundException implements CinemaService {

    @Autowired
    private CinemaRepository cinemaRepository;
    @Autowired
    private ModelMapper mapper;


    @Override
    public CinemaDTO create(CreateCinemaDTO cinemaCreateDto) {
        Cinema cinema = mapper.map(cinemaCreateDto, Cinema.class);
        cinemaRepository.create(cinema);
        return mapper.map(cinema, CinemaDTO.class);
    }

    @Override
    public CinemaDTO findById(int id) {
        Optional<Cinema> cinema = cinemaRepository.findById(id);
        return mapper.map(cinema, CinemaDTO.class);
    }

    @Override
    public CinemaDTO update(UpdateCinemaDTO cinemaUpdateDTO) {
        Optional<Cinema> cinema = cinemaRepository.findById(cinemaUpdateDTO.getId());
        cinema.get().setName(cinemaUpdateDTO.getName());
        cinemaRepository.update(cinema.get());
        return mapper.map(cinema, CinemaDTO.class);
    }

}
