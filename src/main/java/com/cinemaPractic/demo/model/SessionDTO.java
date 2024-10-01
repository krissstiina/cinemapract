package com.cinemaPractic.demo.model;

import java.util.Date;

public class SessionDTO {
    public int id;
    public Date date;
    public int hallId;
    public int filmId;
    public int cinemaId;
    public int availableSeats;

    protected SessionDTO(){}

    public SessionDTO(int id, Date date, int  hall, int film, int cinema, int availableSeats){
        this.id = id;
        this.date = date;
        this.hallId = hall;
        this.filmId = film;
        this.cinemaId = cinema;
        this.availableSeats = availableSeats;
    }

    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinema) {
        this.cinemaId = cinema;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public int getHallId() {
        return hallId;
    }

    public void setHallId(int hall) {
        this.hallId = hall;
    }

    public int getFilmID() {
        return filmId;
    }

    public void setFilmId(int film) {
        this.filmId = film;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
}
