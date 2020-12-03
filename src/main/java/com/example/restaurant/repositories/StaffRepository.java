package com.example.restaurant.repositories;

import com.example.restaurant.entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StaffRepository extends JpaRepository<Staff, Integer> {
    List<Staff> findAll();
    List<Staff> findAllById(Integer id);

    @Override
    <S extends Staff> S save(S s);
}
