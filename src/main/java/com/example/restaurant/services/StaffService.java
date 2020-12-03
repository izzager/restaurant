package com.example.restaurant.services;

import com.example.restaurant.entities.Dish;
import com.example.restaurant.entities.Staff;
import com.example.restaurant.repositories.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {
    @Autowired
    StaffRepository staffRepository;

    public StaffService() {}

    public List<Staff> findAll() {
        return staffRepository.findAll();
    }

    public <S extends Staff> S save(S s) {
        return staffRepository.save(s);
    }
}
