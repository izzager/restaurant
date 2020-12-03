package com.example.restaurant.entities;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DateString {
    String date1;
    String date2;
    LocalDateTime dateT1;
    LocalDateTime dateT2;

    public DateString() {
        date1 = "";
        date2 = "";
        dateT1 = LocalDateTime.now();
        dateT2 = LocalDateTime.now();
    }

    public LocalDateTime toDate1() {
        return LocalDateTime.parse(date1);
    }

    public LocalDateTime toDate2() {
        return LocalDateTime.parse(date2);
    }
}
