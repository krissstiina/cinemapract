package com.cinemaPractic.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinemaPractic.demo.entites.Cinema;
import com.cinemaPractic.demo.exception.CinemaNotFoundException;
import com.cinemaPractic.demo.model.CinemaDTO;
import com.cinemaPractic.demo.model.CreateCinemaDTO;
import com.cinemaPractic.demo.model.UpdateCinemaDTO;
import com.cinemaPractic.demo.repositories.CinemaRepository;
import com.cinemaPractic.demo.service.CinemaService;

@Service
public class CinemaServiceImpl extends CinemaNotFoundException implements CinemaService {
    @Autowired
    private CinemaRepository cinemaRepository;
    
    private ModelMapper modelMapper;
    public CinemaServiceImpl(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    @Override
    public CinemaDTO create(CreateCinemaDTO cinemaDTO) {
        Cinema cinema = modelMapper.map(cinemaDTO,Cinema.class);
        cinemaRepository.create(cinema);
        return modelMapper.map(cinema, CinemaDTO.class);
    }

    @Override
    public Optional<CinemaDTO> findById(int id){
        Optional<Cinema> cinema = cinemaRepository.findById(id);
        if (!cinema.isPresent()){
            throw new CinemaNotFoundException();
        }
        return Optional.of(modelMapper.map(cinema,CinemaDTO.class));
    }

    @Override
    public CinemaDTO update(UpdateCinemaDTO cinemaDTO) {
        Optional <Cinema> cinema = cinemaRepository.findById(cinemaDTO.id);
        if (!cinema.isPresent()){
            throw new CinemaNotFoundException();
        }
        cinemaRepository.update(cinema.get());
        return modelMapper.map(cinema,CinemaDTO.class);
    }

    @Override
    public List<CinemaDTO> findAll() {
        return cinemaRepository.findAll().stream().map((cinema) -> modelMapper.map(cinema,CinemaDTO.class)).toList();
    }
}
