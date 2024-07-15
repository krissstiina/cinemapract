package com.cinemaPractic.demo.model;

import com.cinemaPractic.demo.entites.Session;
import com.cinemaPractic.demo.entites.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TicketDTO {
    private int id;
    private int price;
    private Session session;
    private User user;
}
