package com.cinemaPractic.demo.model;

public class TicketDTO {
    public int id;
    public int price;
    public int session;
    public int user;

    public TicketDTO(int id, int price, int session, int user){
        this.id = id;
        this.price = price;
        this.session = session;
        this.user = user;
    }

    protected TicketDTO(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
