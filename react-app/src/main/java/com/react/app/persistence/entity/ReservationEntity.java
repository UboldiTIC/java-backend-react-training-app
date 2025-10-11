package com.react.app.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "reservation")
@Getter
@Setter
@NoArgsConstructor
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reservation", nullable = false)
    private Integer idReservation;

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

    /* Ver si es necesario agregarlos como clave primaria compuesta antes de crear las relaciones. */

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @JsonIgnore
    private UserEntity user;

    /* @ManyToOne(fetch = FetchType.LAZY) */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_device", referencedColumnName = "id_device", nullable = false)
    /*Ver recursión infinita - se quitó @JsonIgnore - ver DTO*/
    @JsonIgnoreProperties({"reservations"})
    private DeviceEntity device;
}