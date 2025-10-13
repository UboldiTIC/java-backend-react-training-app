package com.react.app.web.controller;

import com.react.app.persistence.entity.ReservationEntity;
import com.react.app.service.ReservationService;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public ResponseEntity<Page<ReservationEntity>> getAll(@RequestParam(defaultValue = "0") int page,
                                                          @RequestParam(defaultValue = "8") int elements) {
        return ResponseEntity.ok(this.reservationService.getAll(page, elements));
    }

    @GetMapping("/dates/{date}")
    public ResponseEntity<Page<ReservationEntity>> getByDate(@PathVariable LocalDate date,
                                                             @RequestParam(defaultValue = "0") int page,
                                                             @RequestParam(defaultValue = "8") int elements,
                                                             @RequestParam(defaultValue = "date") String sortBy) {
        return ResponseEntity.ok(this.reservationService.getByDate(date, page, elements, sortBy));
    }

    @GetMapping("/teacher/{teacher}")
    public ResponseEntity<List<ReservationEntity>> getByTeacher(@PathVariable String teacher) {
        return ResponseEntity.ok(this.reservationService.getByTeacher(teacher));
    }
    /*
    @GetMapping("/date/{date}")
    public ReservationEntity getByDate(@PathVariable LocalDate date) {
        return this.reservationService.getByDate(date);
    }
    */

    @GetMapping("/date/{date}")
    public ResponseEntity<List<ReservationEntity>> getByDate(@PathVariable LocalDate date) {
        return ResponseEntity.ok(this.reservationService.getByDate(date));
    }

    @GetMapping("/today")
    public ResponseEntity<List<ReservationEntity>> getTodayReservations() {
        return ResponseEntity.ok(this.reservationService.getTodayReservations());
    }

    /*Controlador SQL Nativo*/
    @GetMapping("/user/{id}")
    public ResponseEntity<List<ReservationEntity>> getUserReservations(@PathVariable String id) {
        return ResponseEntity.ok(this.reservationService.getUserReservations(id));
    }

}
