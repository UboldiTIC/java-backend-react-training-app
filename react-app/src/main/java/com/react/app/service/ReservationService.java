package com.react.app.service;

import com.react.app.persistence.entity.ReservationEntity;
import com.react.app.persistence.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    public List<ReservationEntity> getByTeacher(String teacher) {
        return this.reservationRepository.findAllByTeacherIgnoreCase(teacher);
    }

    public ReservationEntity getByDate(LocalDate date) {
        LocalDateTime today = date.atTime(0, 0);
        return this.reservationRepository.findAllByDate(today);
    }

    public List<ReservationEntity> getTodayReservations() {
        LocalDateTime today = LocalDate.now().atTime(0, 0);
        return this.reservationRepository.findAllByDateAfter(today);
    }

}
