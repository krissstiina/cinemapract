package com.cinemaPractic.demo.model;

public class CreateTicketDTO {
    public int price;
    public int session;
    public int user;

    protected CreateTicketDTO(){}

    public CreateTicketDTO(int price, int session, int user){
        this.price = price;
        this.session = session;
        this.user = user;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSession() {
        return session;
    }

    public void setSession(int session) {
        this.session = session;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }
}
