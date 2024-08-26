package com.cinemaPractic.demo.service;

import com.cinemaPractic.demo.model.CreateUserDTO;
import com.cinemaPractic.demo.model.UpdateUserDTO;
import com.cinemaPractic.demo.model.UserDTO;

public interface UserService {
    UserDTO update(UpdateUserDTO userUpdateDTO);
    UserDTO findById(int id);
    UserDTO create(CreateUserDTO userCreateDto);
}
