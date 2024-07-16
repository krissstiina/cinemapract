package com.cinemaPractic.demo.model;


public class UpdateHallDTO {
    public int id;
    public int capacity;
    public int cinema;

    protected UpdateHallDTO(){}

    public UpdateHallDTO(int id, int capacity, int cinema){
        this.id = id;
        this.capacity = capacity;
        this.cinema = cinema;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getCinema() {
        return cinema;
    }

    public void setCinema(int cinema) {
        this.cinema = cinema;
    }
    
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
