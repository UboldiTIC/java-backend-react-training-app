package com.react.app.persistence.projection;

import java.time.LocalDateTime;
import java.time.LocalTime;

public interface ReservationSummary {
    /*Aquí van los atributos que necesitamos en nuestro Query - en forma de get*/
    Integer getIdReservation();
    String getTeacherName();
    LocalDateTime getReservationDate();
    LocalTime getFromTime();
    LocalTime getToTime();
    String getDeviceName();
}
