package com.cinemaPractic.demo.models;

import jakarta.persistence.Column;

public class User  extends BaseEntity{
    private String name;
    private String surname;
    private String middleName;
    private int numberOfVisit;
    private int phoneNumber;

    protected User(){}

    public User(String name, String surname, String middleName, int numberOfVisit, int phoneNumber){
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.numberOfVisit = numberOfVisit;
        this.phoneNumber = phoneNumber;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Column(name = "middle_Name")
    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Column(name = "number_of_visit")
    public int getNumberOfVisit() {
        return numberOfVisit;
    }

    public void setNumberOfVisit(int numberOfVisit) {
        this.numberOfVisit = numberOfVisit;
    }

    @Column(name = "phone_number")
    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
