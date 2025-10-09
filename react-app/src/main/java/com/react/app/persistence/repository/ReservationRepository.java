package com.react.app.persistence.repository;

import com.react.app.persistence.entity.ReservationEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ReservationRepository extends ListCrudRepository<ReservationEntity, Integer> {

    List<ReservationEntity> findAllByTeacherIgnoreCase(String teacher);
    ReservationEntity findAllByDate(LocalDateTime date);
    List<ReservationEntity> findAllByDateAfter(LocalDateTime date);

}
