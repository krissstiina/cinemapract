package com.cinemaPractic.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;

public class Ticket {
    private int price;
    private Session session;
    private User user;

    protected Ticket(){}

    public Ticket(int price, Session session, User user){
        this.price = price;
        this.session = session;
        this.user = user;
    }

    @Column(name = "price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @Column(name = "session_id")
    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @Column(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}

