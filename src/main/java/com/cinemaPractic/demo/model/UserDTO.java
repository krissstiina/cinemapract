package com.cinemaPractic.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private int id;
    private String name;
    private String surname;
    private String middleName;
    private int numberOfVisit;
    private int phoneNumber;
    private int points = 0;
}
