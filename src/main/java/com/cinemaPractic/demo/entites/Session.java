package com.cinemaPractic.demo.entites;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "session")
public class Session extends BaseEntity {
    private Date date;
    private Hall hall;
    private Film film;
    private Cinema cinema;
    private int availableSeats;

    protected Session(){}

    public Session(Date date, Hall  hall, Film film, Cinema cinema, int availableSeats){
        this.date = date;
        this.hall = hall;
        this.film = film;
        this.cinema = cinema;
        this.availableSeats = availableSeats;
    }

    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hall_id")
    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    @ManyToOne
    @JoinColumn(name = "cinema_id")
    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "film_id")
    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    @Column(name = "available_seats")
    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
}

