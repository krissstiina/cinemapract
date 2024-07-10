package com.cinemaPractic.demo.models;

import java.sql.Time;

import javax.xml.crypto.Data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "session")
public class Session extends BaseEntity {
    private Data data;
    private Time time;
    private Hall hall;
    private Film film;

    protected Session(){}

    public Session(Data data, Time time, Hall  hall, Film film){
        this.data = data;
        this.time = time;
        this.hall = hall;
        this.film = film;
    }

    @Column(name = "data")
    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Column(name = "time")
    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "hall_id")
    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "film_id")
    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

}

