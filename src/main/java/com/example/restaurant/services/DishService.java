package com.example.restaurant.services;

import com.example.restaurant.entities.Dish;
import com.example.restaurant.repositories.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
public class DishService implements IDishService {
    @Autowired
    public DishRepository dishRepository;

    public DishService() {}

    @Override
    public List<Dish> findAll() {
        return dishRepository.findAll();
    }

    @Override
    public Optional<Dish> findById(int id) {
        return dishRepository.findById(id);
    }

    public Optional<Dish> findFirstByDishName(String dishName) {
        return dishRepository.findFirstByDishName(dishName);
    }

    public <S extends Dish> S save(S s) {
        return dishRepository.save(s);
    }

}
