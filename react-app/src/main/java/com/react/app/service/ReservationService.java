package com.react.app.service;

import com.react.app.persistence.entity.ReservationEntity;
import com.react.app.persistence.repository.ReservationPagSortRepository;
import com.react.app.persistence.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final ReservationPagSortRepository reservationPagSortRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository, ReservationPagSortRepository reservationPagSortRepository) {
        this.reservationRepository = reservationRepository;
        this.reservationPagSortRepository = reservationPagSortRepository;
    }

    /*
    >De ReservationRepository:

    public List<ReservationEntity> getAll() {
        return this.reservationRepository.findAll();
    }
    */

    /* De Paging and Sorting Repository: */
    public Page<ReservationEntity> getAll(int page, int elements) {
        Pageable pageRequest = PageRequest.of(page, elements);
        return this.reservationPagSortRepository.findAll(pageRequest);
    }

    public List<ReservationEntity> getByTeacher(String teacher) {
        return this.reservationRepository.findAllByTeacherIgnoreCase(teacher);
    }
    /*
    public ReservationEntity getByDate(LocalDate date) {
        LocalDateTime today = date.atTime(0, 0);
        return this.reservationRepository.findAllByDate(today);
    }
    */
    /*
    public ReservationEntity getByDate(LocalDate date) {
        LocalDateTime today = date.atTime(0, 0);
        return this.reservationRepository.findAllByDate(today).orElseThrow(() -> new RuntimeException("Aún no hay reservas ese día"));
    }
    */

    public List<ReservationEntity> getByDate(LocalDate date) {
        LocalDateTime today = date.atTime(0, 0);
        List<ReservationEntity> reservations = this.reservationRepository.findAllByDate(today);
        if (reservations.isEmpty()) {
            throw new RuntimeException("Aún no hay reservas ese día");
        }
        return reservations;
    }


    public List<ReservationEntity> getTodayReservations() {
        LocalDateTime today = LocalDate.now().atTime(0, 0);
        return this.reservationRepository.findAllByDateAfter(today);
    }

}
