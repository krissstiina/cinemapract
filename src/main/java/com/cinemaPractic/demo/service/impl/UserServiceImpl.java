package com.cinemaPractic.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinemaPractic.demo.entites.User;
import com.cinemaPractic.demo.exception.UserNotFoundException;
import com.cinemaPractic.demo.model.CreateUserDTO;
import com.cinemaPractic.demo.model.UpdateUserDTO;
import com.cinemaPractic.demo.model.UserDTO;
import com.cinemaPractic.demo.repositories.UserRepository;
import com.cinemaPractic.demo.service.UserService;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    
    private ModelMapper modelMapper;
    public UserServiceImpl(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDTO create(CreateUserDTO userDTO) {
        User user = modelMapper.map(userDTO,User.class);
        userRepository.create(user);
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public Optional<UserDTO> findById(int id){
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()){
            throw new UserNotFoundException();
        }
        return Optional.of(modelMapper.map(user,UserDTO.class));
    }

    @Override
    public UserDTO update(UpdateUserDTO userDTO) {
        Optional <User> user = userRepository.findById(userDTO.id);
        if (!user.isPresent()){
            throw new UserNotFoundException();
        }
        userRepository.update(user.get());
        return modelMapper.map(user,UserDTO.class);
    }

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream().map((user) -> modelMapper.map(user,UserDTO.class)).toList();
    }
}
