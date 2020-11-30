package com.example.restaurant.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Table(name = "UserOrders")
@NamedStoredProcedureQuery(name = "Order.addDishToOrder",
        procedureName = "sp_addDishToOrderJ", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "order_id", type = Long.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "dishes_id", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "res", type = Boolean.class)})
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long idUser;
    private Date orderDate;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Dish> dishes;

    @Transient
    private double summa;

    public Order() {}

    public Order(Long idUser, Date orderDate) {
        this.idUser = idUser;
        this.orderDate = orderDate;
    }
}
