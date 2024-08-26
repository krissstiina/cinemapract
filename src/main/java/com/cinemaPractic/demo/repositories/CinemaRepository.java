package com.cinemaPractic.demo.repositories;


import org.springframework.stereotype.Repository;

import com.cinemaPractic.demo.entites.Cinema;
import com.cinemaPractic.demo.repositories.generic.CreateRepository;
import com.cinemaPractic.demo.repositories.generic.ReadRepository;
import com.cinemaPractic.demo.repositories.generic.UpdateRepository;

@Repository
public interface CinemaRepository extends ReadRepository<Cinema>, CreateRepository<Cinema>, UpdateRepository<Cinema> {
}
