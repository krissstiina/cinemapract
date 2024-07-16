package com.cinemaPractic.demo.model;

public class CreateCinemaDTO {
    public String address;
    public String name;
    public String metro;

    protected CreateCinemaDTO(){}

    public CreateCinemaDTO (String address, String name, String metro){
        this.address = address;
        this.name = name;
        this.metro = metro;
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
