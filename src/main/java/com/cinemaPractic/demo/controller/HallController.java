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

import com.cinemaPractic.demo.model.CreateHallDTO;
import com.cinemaPractic.demo.model.HallDTO;
import com.cinemaPractic.demo.model.UpdateHallDTO;
import com.cinemaPractic.demo.service.HallService;

@RestController
@RequestMapping("/api/hall")
public class HallController {
    @Autowired
    private HallService hallService;

    @GetMapping("/{id}")
    public HallDTO getById(@PathVariable int id) {
        Optional<HallDTO> hallDTO = hallService.findById(id);
        return hallDTO.get();
    }

    @GetMapping("")
    public List<HallDTO> getAll(){
        return hallService.findAll();
    }

    @PostMapping("")
    public HallDTO create(@RequestBody CreateHallDTO createHallDTO){
        return hallService.create(createHallDTO);
    }

    @PatchMapping("")
    public HallDTO update(@RequestBody UpdateHallDTO updateHallDTO){
        return hallService.update(updateHallDTO);
    }
}
