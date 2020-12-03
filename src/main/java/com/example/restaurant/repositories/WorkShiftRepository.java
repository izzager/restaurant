package com.example.restaurant.repositories;

import com.example.restaurant.entities.WorkShift;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface WorkShiftRepository extends JpaRepository<WorkShift, Integer> {
    List<WorkShift> findAll();

    List<WorkShift> findAllByTimeStartGreaterThanAndTimeEndLessThan(LocalDateTime timeStart,
                                                                    LocalDateTime timeEnd);

}
