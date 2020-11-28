package com.example.restaurant.services;

import com.example.restaurant.entities.Order;
import com.example.restaurant.repositories.DishRepository;
import com.example.restaurant.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrderService {
    @Autowired
    public OrderRepository orderRepository;
    @Autowired
    public DishRepository dishRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public List<Order> findAllByIdUser(Long idUser) {
        return orderRepository.findAllByIdUser(idUser);
    }
}
