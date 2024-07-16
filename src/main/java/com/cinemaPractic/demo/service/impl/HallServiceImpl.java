package com.cinemaPractic.demo.service.impl;

import java.util.List;
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
import com.cinemaPractic.demo.model.HallDTO;
import com.cinemaPractic.demo.model.SessionDTO;
import com.cinemaPractic.demo.model.UpdateHallDTO;
import com.cinemaPractic.demo.repositories.CinemaRepository;
import com.cinemaPractic.demo.repositories.HallRepository;
import com.cinemaPractic.demo.service.HallService;

@Service
public class HallServiceImpl implements HallService {

    @Autowired
    private HallRepository hallRepository;

    @Autowired
    private CinemaRepository cinemaRepository;
    
    private ModelMapper modelMapper;
    public HallServiceImpl(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    @Override
    public HallDTO create(CreateHallDTO hallDTO) {
        Cinema cinema = cinemaRepository.findById(hallDTO.getCinema()).orElseThrow(() -> new CinemaNotFoundException());
        
        Hall hall = new Hall(hallDTO.getCapacity(), cinema);
        hallRepository.create(hall);
        return modelMapper.map(hall, HallDTO.class);
    }

    @Override
    public void delete(int id) {
        hallRepository.delete(id);
    }

    @Override
    public Optional<HallDTO> findById(int id){
        Optional<Hall> hall = hallRepository.findById(id);
        if (!hall.isPresent()){
            throw new HallNotFoundException();
        }
        return Optional.of(modelMapper.map(hall,HallDTO.class));
    }

    @Override
    public HallDTO update(UpdateHallDTO hallDTO) {
        Optional<Hall> hall = hallRepository.findById(hallDTO.getId());
        if (!hall.isPresent()) {
            throw new HallNotFoundException();
        }

        if(hallDTO.getCinema() != 0) {
            Cinema cinema = cinemaRepository.findById(hallDTO.getCinema()).orElseThrow(() -> new CinemaNotFoundException());
            hall.get().setCinema(cinema);
        }

        hall.get().setCapacity(hallDTO.getCapacity());
        hallRepository.update(hall.get());

        return modelMapper.map(hall, HallDTO.class);
    }

    @Override
    public List<HallDTO> findAll() {
        return hallRepository.findAll().stream().map((hall) -> modelMapper.map(hall,HallDTO.class)).toList();
    }
}
