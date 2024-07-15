package com.cinemaPractic.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinemaPractic.demo.entites.Hall;
import com.cinemaPractic.demo.repositories.HallRepository;
import com.cinemaPractic.demo.service.HallService;

@Service
public class HallServiceImpl implements HallService {

    @Autowired
    private HallRepository hallRepository;


    @Override
    public void deleteHall(int id) {
        hallRepository.deleteHall(id);
    }

    @Transactional
    @Override
    public void createHall(Hall hall) {
        hallRepository.createHall(hall);
    }
}
