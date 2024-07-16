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

import com.cinemaPractic.demo.entites.Film;
import com.cinemaPractic.demo.entites.User;
import com.cinemaPractic.demo.model.CreateFilmDTO;
import com.cinemaPractic.demo.model.FilmDTO;
import com.cinemaPractic.demo.model.UpdateFilmDTO;
import com.cinemaPractic.demo.service.FilmService;

@RestController
@RequestMapping("/api/film")
public class FilmController {
    @Autowired
    private FilmService filmService;


    @GetMapping("/{id}")
    public FilmDTO getById(@PathVariable int id) {
        Optional<FilmDTO> filmDTO = filmService.findById(id);
        return filmDTO.get();
    }

    @GetMapping("")
    public List<FilmDTO> getAll(){
        return filmService.findAll();
    }

    @PostMapping("")
    public FilmDTO create(@RequestBody CreateFilmDTO createFilmDTO){
        return filmService.create(createFilmDTO);
    }

    @PatchMapping("")
    public FilmDTO update(@RequestBody UpdateFilmDTO updateFilmDTO){
        return filmService.update(updateFilmDTO);
    }

    // @GetMapping("/user/{userId}/recommendations")
    // public List<Film> getFilmRecommendations(@PathVariable int userId) {
    //     User user = new User();
    //     user.setId(userId);
    //     List<Film> recommendedFilms = filmService.getRecommendations(user);
    //     return recommendedFilms;
    // }
    
}
