package com.example.restaurant.entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Dishes")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String dishName;
    private String category;
    private int price;
    private boolean inMenu;

    @Transient
    @ManyToMany(mappedBy = "dishes")
    private Set<Order> orders;

    public Dish() {}

    public Dish(String dishName, String category, int price, boolean inMenu) {
        this.dishName = dishName;
        this.category = category;
        this.price = price;
        this.inMenu = inMenu;
    }

    public Integer getId() { return id; }

    public String getDishName() { return dishName; }

    public int getPrice() { return price; }

    public String getCategory() { return category; }

    public boolean isInMenu() { return inMenu; }

    public void setDishName(String dishName) { this.dishName = dishName; }

    public void setCategory(String category) { this.category = category; }

    public void setPrice(int price) { this.price = price; }

    public void setInMenu(boolean inMenu) { this.inMenu = inMenu; }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", dishName='" + dishName + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", inMenu=" + inMenu +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return price == dish.price &&
                inMenu == dish.inMenu &&
                Objects.equals(id, dish.id) &&
                Objects.equals(dishName, dish.dishName) &&
                Objects.equals(category, dish.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dishName, category, price, inMenu);
    }
}
