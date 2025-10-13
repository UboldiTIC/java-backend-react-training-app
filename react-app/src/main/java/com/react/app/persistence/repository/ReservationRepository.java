package com.react.app.persistence.repository;

import com.react.app.persistence.entity.ReservationEntity;
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

}
