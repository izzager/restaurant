package com.example.restaurant.services;

import com.example.restaurant.entities.User;

import java.util.Optional;

public interface IUserService {
    User findById(Long id);
    Optional<User> findUserByUsernameAndPassword(String username, String password);
}
