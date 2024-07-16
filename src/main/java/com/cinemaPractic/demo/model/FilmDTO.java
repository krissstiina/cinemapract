package com.cinemaPractic.demo.model;

public class FilmDTO {
    public int id;
    public String name;
    public String genre;
    public String producer;
    public int yearOfPublish;
    public double  rating;

    public FilmDTO(int id, String name, String genre, String producer, int yearOfPublish, double rating){
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.producer = producer;
        this.yearOfPublish = yearOfPublish;
        this.rating = rating;
    }

    protected FilmDTO() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public String getProducer() {
        return producer;
    }

    public double getRating() {
        return rating;
    }
    
    public int getYearOfPublish() {
        return yearOfPublish;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public void setYearOfPublish(int yearOfPublish) {
        this.yearOfPublish = yearOfPublish;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
