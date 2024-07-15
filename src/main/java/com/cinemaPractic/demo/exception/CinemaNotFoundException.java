package com.cinemaPractic.demo.exception;

public class CinemaNotFoundException extends RuntimeException{
    public CinemaNotFoundException(){
        super("Cinema not found");
    }
    
}
