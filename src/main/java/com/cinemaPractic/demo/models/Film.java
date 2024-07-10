package com.cinemaPractic.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "film")
public class Film extends BaseEntity {
    private String name;
    private String genre;
    private String producer;
    private int yearOfPublish;

    protected Film(){}

    public Film(String name, String genre, String producer, int yearOfPublish){
        this.name = name;
        this.genre = genre;
        this.producer = producer;
        this.yearOfPublish = yearOfPublish;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "genre")
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Column(name = "producer")
    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Column(name = "yearOfPublish")
    public int getYearOfPublish() {
        return yearOfPublish;
    }

    public void setYearOfPublish(int yearOfPublish) {
        this.yearOfPublish = yearOfPublish;
    }

}

