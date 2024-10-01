package com.cinemaPractic.demo.service;

import java.util.Optional;

import com.cinemaPractic.demo.model.CreateUserDTO;
import com.cinemaPractic.demo.model.UpdateUserDTO;
import com.cinemaPractic.demo.model.UserDTO;

public interface UserService {
    UserDTO update(UpdateUserDTO userUpdateDTO);
    Optional<UserDTO> findById(int id);
    UserDTO create(CreateUserDTO userCreateDto);
}
