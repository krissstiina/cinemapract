package com.cinemaPractic.demo.model;

import java.util.Date;

public class CreateSessionDTO {
    public Date date;
    public int hall;
    public int film;
    public int availableSeats;

    protected CreateSessionDTO(){}

    public CreateSessionDTO(Date date, int  hall, int film, int availableSeats){
        this.date = date;
        this.hall = hall;
        this.film = film;
        this.availableSeats = availableSeats;
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



