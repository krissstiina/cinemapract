package com.cinemaPractic.demo.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
@Entity
@Table(name = "cinema")
public class Cinema extends BaseEntity {
    private String address;
    private String name;
    private String metro;

    protected Cinema(){
    }

    public Cinema (String address, String name, String metro){
        this.address = address;
        this.name = name;
        this.metro = metro;
    }

    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "metro")
    public String getMetro() {
        return metro;
    }

    public void setMetro(String metro) {
        this.metro = metro;
    }

}
