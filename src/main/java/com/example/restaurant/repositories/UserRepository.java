package com.example.restaurant.repositories;

import com.example.restaurant.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findUserByUserLoginAndAndUserPassword(String userLogin, String userPassword);
}
