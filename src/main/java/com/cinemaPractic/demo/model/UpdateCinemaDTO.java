package com.cinemaPractic.demo.model;

public class UpdateCinemaDTO{
    public int id;
    public String address;
    public String name;
    public String metro;

    protected UpdateCinemaDTO(){}

    public UpdateCinemaDTO (int id, String address, String name, String metro){
        this.id = id;
        this.address = address;
        this.name = name;
        this.metro = metro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMetro() {
        return metro;
    }

    public void setMetro(String metro) {
        this.metro = metro;
    }

}
