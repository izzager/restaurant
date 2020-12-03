package com.example.restaurant.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Staff")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String F;
    private String I;
    private String O;
    private String position;
    private int passport;
    private int salaryPerHour;
    private boolean statusStaff;

    @Transient
    private String checked = "checked";

    public Staff() {}

    public Staff(String F, String I, String O, String position,
                 int passport, int salaryPerHour, boolean statusStaff) {
        this.F = F;
        this.I = I;
        this.O = O;
        this.position = position;
        this.passport = passport;
        this.salaryPerHour = salaryPerHour;
        this.statusStaff = statusStaff;
        checked = statusStaff ? "checked" : "unchecked";
    }
}
