package com.cinemaPractic.demo.model;

import java.util.Date;

import com.cinemaPractic.demo.entites.Film;
import com.cinemaPractic.demo.entites.Hall;

public class CreateSessionDTO {
    public Date date;
    public Hall hall;
    public Film film;
    public int availableSeats;
}
