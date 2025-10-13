package com.react.app.persistence.repository;

import com.react.app.persistence.entity.ReservationEntity;
import com.react.app.persistence.projection.ReservationSummary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends ListCrudRepository<ReservationEntity, Integer> {

    List<ReservationEntity> findAllByTeacherIgnoreCase(String teacher);
    /*ReservationEntity findAllByDate(LocalDateTime date);*/
    /*Optional<ReservationEntity> findAllByDate(LocalDateTime date);*/
    List<ReservationEntity> findAllByDate(LocalDateTime date);
    List<ReservationEntity> findAllByDateAfter(LocalDateTime date);

    /*Consultas con SQL nativo:*/
    @Query(value = "SELECT * FROM reservation WHERE id_user = :id", nativeQuery = true)
    List<ReservationEntity> getUserReservations(@Param("id")String idUser);

    @Query(value =
            "SELECT " +
            "    r.id_reservation AS idReservation, " +
            "    r.teacher AS teacherName, " +
            "    r.date AS reservationDate, " +
            "    r.start_time AS fromTime, " +
            "    r.end_time AS toTime, " +
            "    d.name AS deviceName " +
            "FROM reservation r " +
            "   INNER JOIN device d ON r.id_device = d.id_device " +
            "WHERE r.id_reservation = :reservationId ", nativeQuery = true)
    ReservationSummary findSummary(@Param("reservationId") int reservationId);

}
