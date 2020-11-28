package com.example.restaurant.services;

import com.example.restaurant.entities.Dish;

import java.util.List;
import java.util.Optional;

public interface IDishService {
    List<Dish> findAll();
    Optional<Dish> findById(int id);
}
