package com.cinemaPractic.demo.model;

import java.util.Date;

import com.cinemaPractic.demo.entites.Film;
import com.cinemaPractic.demo.entites.Hall;

public class SessionDTO {
    private Date date;
    private Hall hall;
    private Film film;
    private int availableSeats;
}
