package com.example.restaurant.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "Dishes")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String dishName;
    private String category;
    private int price;
    private boolean inMenu;

    @Transient
    @ManyToMany(mappedBy = "dishes")
    private Set<Order> orders;

    @Transient
    private String checked = "checked";

    public Dish() {}

    public Dish(String dishName, String category, int price, boolean inMenu) {
        this.dishName = dishName;
        this.category = category;
        this.price = price;
        this.inMenu = inMenu;
        checked = inMenu ? "checked" : "unchecked";
    }

}
