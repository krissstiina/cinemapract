package com.cinemaPractic.demo.entites;

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
    private int rating;

    protected Film(){}

    public Film(String name, String genre, String producer, int yearOfPublish, int rating){
        this.name = name;
        this.genre = genre;
        this.producer = producer;
        this.yearOfPublish = yearOfPublish;
        this.rating = rating;
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

    @Column(name = "year_of_publish")
    public int getYearOfPublish() {
        return yearOfPublish;
    }

    public void setYearOfPublish(int yearOfPublish) {
        this.yearOfPublish = yearOfPublish;
    }

    @Column(name = "rating")
    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

}