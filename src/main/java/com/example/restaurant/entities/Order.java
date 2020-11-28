package com.example.restaurant.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "UserOrders")
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

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Long getIdUser() { return idUser; }

    public void setIdUser(Long idUser) { this.idUser = idUser; }

    public Set<Dish> getDishes() { return dishes; }

    public void setDishes(Set<Dish> dishes) { this.dishes = dishes; }

    public Date getOrderDate() { return orderDate; }

    public void setOrderDate(Date orderDate) { this.orderDate = orderDate; }

    public double getSumma() { return summa; }

    public void setSumma(double summa) { this.summa = summa; }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", idUser=" + idUser +
                ", orderDate=" + orderDate +
                ", dishes=" + dishes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) &&
                Objects.equals(idUser, order.idUser) &&
                Objects.equals(orderDate, order.orderDate) &&
                Objects.equals(dishes, order.dishes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idUser, orderDate, dishes);
    }
}
