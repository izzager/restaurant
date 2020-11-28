package com.example.restaurant.repositories;

import com.example.restaurant.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAll();
    List<Order> findAllByIdUser(Long idUser);
}
