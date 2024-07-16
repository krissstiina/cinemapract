package com.cinemaPractic.demo.model;

public class UpdateUserDTO {
    public int id;
    public String name;
    public String surname;
    public String middleName;
    public String phoneNumber;
    public int points = 0;

    public UpdateUserDTO(int id, String name, String surname, String middleName, int numberOfVisit, String phoneNumber, int points){
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.phoneNumber = phoneNumber;
        this.points = points;
        this.id = id;
    }

    protected UpdateUserDTO() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

}
