package com.cinemaPractic.demo.model;

import java.nio.file.attribute.UserDefinedFileAttributeView;

import org.apache.catalina.SessionIdGenerator;

public class TicketDTO {
    public int id;
    public int price;
    public int sessionId;
    public int userId;

    public TicketDTO(int id, int price, int session, int user){
        this.id = id;
        this.price = price;
        this.sessionId = session;
        this.userId = user;
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

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int session) {
        this.sessionId = session;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int user) {
        this.userId = user;
    }
}
