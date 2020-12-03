package com.example.restaurant.repositories;

import com.example.restaurant.entities.Dish;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DishRepository extends CrudRepository<Dish, Integer> {
    List<Dish> findAll();
    Optional<Dish> findById(int id);
    Optional<Dish> findFirstByDishName(String dishName);

    @Override
    <S extends Dish> S save(S s);

}
