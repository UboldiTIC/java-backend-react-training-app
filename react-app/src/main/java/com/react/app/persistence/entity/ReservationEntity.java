package com.react.app.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "reservation")
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reservation", nullable = false)
    private Integer idReservation;

    @Column(name = "id_user", nullable = false, length = 30)
    private String idUser;

    @Column(nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime date;

    @Column(name = "start_time", nullable = false, columnDefinition = "TIME")
    private LocalTime from;

    @Column(name = "end_time", nullable = false, columnDefinition = "TIME")
    private LocalTime to;

    @Column(nullable = false, length = 30)
    private String teacher;

    @Column(length = 250)
    private String note;

}