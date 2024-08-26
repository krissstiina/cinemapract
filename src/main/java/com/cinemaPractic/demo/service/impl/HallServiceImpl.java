package com.cinemaPractic.demo.service.impl;

import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinemaPractic.demo.entites.Film;
import com.cinemaPractic.demo.entites.Hall;
import com.cinemaPractic.demo.model.CreateFilmDTO;
import com.cinemaPractic.demo.model.CreateHallDTO;
import com.cinemaPractic.demo.model.FilmDTO;
import com.cinemaPractic.demo.model.HallDTO;
import com.cinemaPractic.demo.model.UpdateFilmDTO;
import com.cinemaPractic.demo.model.UpdateHallDTO;
import com.cinemaPractic.demo.repositories.impl.HallRepositoryImpl;
import com.cinemaPractic.demo.service.HallService;

@Service
public class HallServiceImpl implements HallService {

    @Autowired
    private HallRepositoryImpl hallRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public HallDTO create(CreateHallDTO hallCreateDto) {
        Hall hall = mapper.map(hallCreateDto, Hall.class);
        hallRepository.create(hall);
        return mapper.map(hall, HallDTO.class);
    }

    @Override
    public HallDTO findById(int id) {
        Optional<Hall> hall = hallRepository.findById(id);


        return mapper.map(hall, HallDTO.class);
    }
}