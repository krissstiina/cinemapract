package com.cinemaPractic.demo.service;

import java.util.List;
import java.util.Optional;

import com.cinemaPractic.demo.model.CreateHallDTO;
import com.cinemaPractic.demo.model.HallDTO;
import com.cinemaPractic.demo.model.UpdateHallDTO;

public interface HallService {
    HallDTO create(CreateHallDTO hallDTO);
    Optional<HallDTO> findById(int id);
    HallDTO update(UpdateHallDTO hallDTO);
    List<HallDTO> findAll();
}
