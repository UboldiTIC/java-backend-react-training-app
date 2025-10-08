package com.react.app.service;

import com.react.app.persistence.entity.ReservationEntity;
import com.react.app.persistence.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<ReservationEntity> getAll() {
        return this.reservationRepository.findAll();
    }

    public ReservationEntity getByTeacher(String teacher) {
        return this.reservationRepository.findAllByTeacherIgnoreCase(teacher);
    }
}
