package com.cinemaPractic.demo.service;

import com.cinemaPractic.demo.model.CreateHallDTO;
import com.cinemaPractic.demo.model.HallDTO;

public interface HallService {
    HallDTO findById(int id);
    HallDTO create(CreateHallDTO hallCreateDto);
    
}
