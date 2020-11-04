package com.example.restaurant.services;

import com.example.restaurant.entities.User;
import com.example.restaurant.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    public UserRepository userRepository;

    public UserService() { }


    @Override
    public Optional<User> findUserByUserLoginAndAndUserPassword(String userLogin, String userPassword) {
        return userRepository.findUserByUserLoginAndAndUserPassword(userLogin, userPassword);
    }
}
