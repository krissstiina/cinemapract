package com.cinemaPractic.demo.model;

import com.cinemaPractic.demo.entites.Cinema;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HallDTO {
    private int capacity;
    private Cinema cinema;
}
