package com.cinemaPractic.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinemaPractic.demo.model.CreateUserDTO;
import com.cinemaPractic.demo.model.TicketDTO;
import com.cinemaPractic.demo.model.UpdateUserDTO;
import com.cinemaPractic.demo.model.UserDTO;
import com.cinemaPractic.demo.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("")
    public UserDTO create(@RequestBody CreateUserDTO createUserDTO){
        return userService.create(createUserDTO);
    }

    @PatchMapping("")
    public UserDTO update(@RequestBody UpdateUserDTO updateUserDTO){
        return userService.update(updateUserDTO);
    }

    @GetMapping("/{id}")
    public Optional<UserDTO> getById(@PathVariable int id){
        return userService.findById(id);
    }
}
