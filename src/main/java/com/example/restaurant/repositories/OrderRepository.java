package com.example.restaurant.repositories;

import com.example.restaurant.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAll();
    List<Order> findAllByIdUser(Long idUser);

    @Override
    <S extends Order> S save(S s);

    @Procedure(name = "Order.addDishToOrder")
    Boolean addDishToOrder(@Param("order_id") Long order_id, @Param("dishes_id") Integer dishes_id);

}
