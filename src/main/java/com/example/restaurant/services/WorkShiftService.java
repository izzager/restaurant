package com.example.restaurant.services;

import com.example.restaurant.entities.WorkShift;
import com.example.restaurant.repositories.WorkShiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class WorkShiftService {
    WorkShiftRepository workShiftRepository;

    @Autowired
    public WorkShiftService(WorkShiftRepository workShiftRepository) {
        this.workShiftRepository = workShiftRepository;
    }

    public List<WorkShift> findAll() {
        return workShiftRepository.findAll();
    }

    public List<WorkShift> findByDate(LocalDateTime timeStart, LocalDateTime timeEnd) {
        return workShiftRepository.findAllByTimeStartGreaterThanAndTimeEndLessThan(timeStart, timeEnd);
    }
}
