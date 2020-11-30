package com.example.restaurant.services;

import com.example.restaurant.entities.Order;
import com.example.restaurant.repositories.DishRepository;
import com.example.restaurant.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class OrderService implements IOrderService {
    @PersistenceContext
    private EntityManager entityManager;

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

    public <S extends Order> S save(S s) {
        return orderRepository.save(s);
    }

    public Order findLastByIdUser(Long idUser) {
        List<Order> orders = orderRepository.findAllByIdUser(idUser);
        return orders.get(orders.size() - 1);
    }

    @Transactional
    public boolean addDishToOrder(Long idOrder, int idDishes) {
        Boolean res = orderRepository.addDishToOrder(idOrder, idDishes);
        entityManager.flush();
        return res;
    }
}
