package com.cinemaPractic.demo.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinemaPractic.demo.entites.User;
import com.cinemaPractic.demo.model.UserDTO;
import com.cinemaPractic.demo.repositories.impl.UserRepositoryImpl;
import com.cinemaPractic.demo.service.UserService;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepositoryImpl userRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public void addUser(UserDTO user) {
        User userToAdd = modelMapper.map(user, User.class);

        userRepository.save(userToAdd);
    }
}
