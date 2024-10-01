package com.cinemaPractic.demo.model;

public class HallDTO {
    public int id;
    public int capacity;
    public int cinemaId;

    protected HallDTO(){}

    public HallDTO(int id, int capacity, int cinema){
        this.capacity = capacity;
        this.cinemaId = cinema;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCinema() {
        return cinemaId;
    }

    public void setCinemaId(int cinema) {
        this.cinemaId = cinema;
    }
    
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
