package com.example.restaurant.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String userLogin;
    private String userPassword;

    public User() { }

    public User(String userLogin, String userPassword) {
        this.userLogin = userLogin;
        this.userPassword = userPassword;
    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getUserLogin() { return userLogin; }

    public String getUserPassword() { return userPassword; }

    public void setUserLogin(String userLogin) { this.userLogin = userLogin; }

    public void setUserPassword(String userPassword) { this.userPassword = userPassword; }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userLogin='" + userLogin + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(userLogin, user.userLogin) &&
                Objects.equals(userPassword, user.userPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userLogin, userPassword);
    }
}
