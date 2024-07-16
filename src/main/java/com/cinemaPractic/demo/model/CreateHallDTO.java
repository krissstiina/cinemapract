package com.cinemaPractic.demo.model;

public class CreateHallDTO {
    public int capacity;
    public int cinema;

    protected CreateHallDTO(){}

    public CreateHallDTO(int capacity, int cinema){
        this.capacity = capacity;
        this.cinema = cinema;
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
