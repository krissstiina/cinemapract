package com.cinemaPractic.demo.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinemaPractic.demo.entites.Cinema;
import com.cinemaPractic.demo.entites.Film;
import com.cinemaPractic.demo.entites.Hall;
import com.cinemaPractic.demo.entites.Session;
import com.cinemaPractic.demo.exception.CinemaNotFoundException;
import com.cinemaPractic.demo.exception.FilmNotFoundException;
import com.cinemaPractic.demo.exception.HallNotFoundException;
import com.cinemaPractic.demo.exception.SessionNotFoundException;
import com.cinemaPractic.demo.model.CreateHallDTO;
import com.cinemaPractic.demo.model.CreateSessionDTO;
import com.cinemaPractic.demo.model.HallDTO;
import com.cinemaPractic.demo.model.SessionDTO;
import com.cinemaPractic.demo.repositories.impl.CinemaRepositoryImpl;
import com.cinemaPractic.demo.repositories.impl.HallRepositoryImpl;
import com.cinemaPractic.demo.service.HallService;

@Service
public class HallServiceImpl implements HallService {

    @Autowired
    private HallRepositoryImpl hallRepository;
    @Autowired
    private CinemaRepositoryImpl cinemaRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public HallDTO create(CreateHallDTO hallDTO) {
        Cinema cinema = cinemaRepository.findById(hallDTO.getCinema()).orElseThrow(() -> new CinemaNotFoundException());
        Hall hall = new Hall(hallDTO.getCapacity(),cinema);
        hallRepository.create(hall);
        return mapper.map(hall, HallDTO.class);
    }

    @Override
    public Optional<HallDTO> findById(int id){
        Optional<Hall> hall = hallRepository.findById(id);
        if (!hall.isPresent()){
            throw new HallNotFoundException();
        }
        return Optional.of(mapper.map(hall,HallDTO.class));
    }
}