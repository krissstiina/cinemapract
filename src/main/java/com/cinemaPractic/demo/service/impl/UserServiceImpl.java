package com.cinemaPractic.demo.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import com.cinemaPractic.demo.entites.Cinema;
import com.cinemaPractic.demo.entites.User;
import com.cinemaPractic.demo.model.CinemaDTO;
import com.cinemaPractic.demo.model.CreateCinemaDTO;
import com.cinemaPractic.demo.model.CreateUserDTO;
import com.cinemaPractic.demo.model.UpdateCinemaDTO;
import com.cinemaPractic.demo.model.UpdateUserDTO;
import com.cinemaPractic.demo.model.UserDTO;
import com.cinemaPractic.demo.repositories.CinemaRepository;
import com.cinemaPractic.demo.repositories.UserRepository;
import com.cinemaPractic.demo.repositories.impl.UserRepositoryImpl;
import com.cinemaPractic.demo.service.UserService;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public UserDTO create(CreateUserDTO userCreateDto) {
        User user = mapper.map(userCreateDto, User.class);
        userRepository.create(user);
        return mapper.map(user, UserDTO.class);
    }

    @Override
    public UserDTO findById(int id) {
        Optional<User> user = userRepository.findById(id);


        return mapper.map(user, UserDTO.class);
    }

    @Override
    public UserDTO update(UpdateUserDTO userUpdateDTO) {
        Optional<User> user = userRepository.findById(userUpdateDTO.getId());
        user.get().setName(userUpdateDTO.getName());
        userRepository.update(user.get());
        return mapper.map(user, UserDTO.class);
    }
}
