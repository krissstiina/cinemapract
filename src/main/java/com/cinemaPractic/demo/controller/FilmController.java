package com.cinemaPractic.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinemaPractic.demo.entites.Film;
import com.cinemaPractic.demo.entites.User;
import com.cinemaPractic.demo.model.CinemaDTO;
import com.cinemaPractic.demo.model.CreateCinemaDTO;
import com.cinemaPractic.demo.model.CreateFilmDTO;
import com.cinemaPractic.demo.model.FilmDTO;
import com.cinemaPractic.demo.model.UpdateCinemaDTO;
import com.cinemaPractic.demo.model.UpdateFilmDTO;
import com.cinemaPractic.demo.service.FilmService;

@RestController
@RequestMapping("/api/film")
public class FilmController {
    @Autowired
    private FilmService filmService;

    @PostMapping("")
    public FilmDTO create(@RequestBody CreateFilmDTO createFilmDTO){
        return filmService.create(createFilmDTO);
    }

    @PatchMapping("")
    public FilmDTO update(@RequestBody UpdateFilmDTO filmUpdateDto){
        return filmService.update(filmUpdateDto);
    }

    @GetMapping("/{id}")
    public FilmDTO getById(@PathVariable int id){
        return filmService.findById(id);
    }

    @GetMapping("/{userId}/recomendation")
    public ResponseEntity<List<FilmDTO>> getRecommendations(@PathVariable int userId) {
        List<FilmDTO> recommendations = filmService.getRecommendations(userId);
        return ResponseEntity.ok(recommendations);
    }

    @GetMapping("/popular")
    public List<Film> getMostPopularFilms() {
        return filmService.getMostPopularFilms();
    }

}
