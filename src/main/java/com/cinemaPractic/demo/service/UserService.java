package com.cinemaPractic.demo.service;

import java.util.Optional;
import java.util.List;

import com.cinemaPractic.demo.model.CreateUserDTO;
import com.cinemaPractic.demo.model.UpdateUserDTO;
import com.cinemaPractic.demo.model.UserDTO;

public interface UserService {
    UserDTO create(CreateUserDTO userDTO);
    public void delete(int id);
    public Optional<UserDTO> findById(int id);
    public List<UserDTO> findAll();
    UserDTO update(UpdateUserDTO userDTO);
}
