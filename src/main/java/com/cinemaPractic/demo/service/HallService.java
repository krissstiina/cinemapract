package com.cinemaPractic.demo.service;

import java.util.Optional;

import com.cinemaPractic.demo.model.CreateHallDTO;
import com.cinemaPractic.demo.model.HallDTO;

public interface HallService {
    Optional<HallDTO> findById(int id);
    HallDTO create(CreateHallDTO hallCreateDto);
    
}
