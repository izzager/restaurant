package com.example.restaurant.services;

import com.example.restaurant.entities.User;

import java.util.Optional;

public interface IUserService {
    Optional<User> findUserByUserLoginAndAndUserPassword(String userLogin, String userPassword);
}
