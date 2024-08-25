package com.cinemaPractic.demo.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinemaPractic.demo.entites.Hall;
import com.cinemaPractic.demo.model.HallDTO;
import com.cinemaPractic.demo.repositories.impl.HallRepositoryImpl;
import com.cinemaPractic.demo.service.HallService;

@Service
public class HallServiceImpl implements HallService {

    @Autowired
    private HallRepositoryImpl hallRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public void addHall(HallDTO hall) {
        Hall hallToAdd = modelMapper.map(hall, Hall.class);

        hallRepository.save(hallToAdd);
    }
}