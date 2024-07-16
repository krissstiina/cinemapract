package com.cinemaPractic.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinemaPractic.demo.model.CinemaDTO;
import com.cinemaPractic.demo.model.CreateCinemaDTO;
import com.cinemaPractic.demo.model.UpdateCinemaDTO;
import com.cinemaPractic.demo.service.CinemaService;

@RestController
@RequestMapping("/api/cinema")
public class CinemaController {
    @Autowired
    private CinemaService cinemaService;

    @GetMapping("/{id}")
    public CinemaDTO getById(@PathVariable int id) {
        Optional<CinemaDTO> cinemaDTO = cinemaService.findById(id);
        return cinemaDTO.get();
    }

    @GetMapping("")
    public List<CinemaDTO> getAll(){
        return cinemaService.findAll();
    }

    @PostMapping("")
    public CinemaDTO create(@RequestBody CreateCinemaDTO createCinemaDTO){
        return cinemaService.create(createCinemaDTO);
    }

    @PatchMapping("")
    public CinemaDTO update(@RequestBody UpdateCinemaDTO updateCinemaDTO){
        return cinemaService.update(updateCinemaDTO);
    }

}
