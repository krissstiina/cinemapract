package com.cinemaPractic.demo.model;

public class CreateUserDTO {
    public String name;
    public String surname;
    public String middleName;
    public String phoneNumber;
    public int points = 0;

    public CreateUserDTO(String name, String surname, String middleName, String phoneNumber, int points){
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.phoneNumber = phoneNumber;
        this.points = points;
    }

    protected CreateUserDTO() {}

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
