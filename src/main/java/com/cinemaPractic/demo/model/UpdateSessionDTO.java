package com.cinemaPractic.demo.model;

import java.util.Date;


public class UpdateSessionDTO {
    public int id;
    public Date date;
    public int hall;
    public int film;
    public int cinema;
    public int availableSeats;

    protected UpdateSessionDTO(){}

    public UpdateSessionDTO(int id, Date date, int  hall, int film, int cinema, int availableSeats){
        this.id = id;
        this.date = date;
        this.hall = hall;
        this.film = film;
        this.cinema = cinema;
        this.availableSeats = availableSeats;
    }

    public int getCinema() {
        return cinema;
    }

    public void setCinema(int cinema) {
        this.cinema = cinema;
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
    
    public int getHall() {
        return hall;
    }

    public void setHall(int hall) {
        this.hall = hall;
    }

    public int getFilm() {
        return film;
    }

    public void setFilm(int film) {
        this.film = film;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
}
