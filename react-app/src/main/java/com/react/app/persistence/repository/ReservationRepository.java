package com.react.app.persistence.repository;

import com.react.app.persistence.entity.ReservationEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface ReservationRepository extends ListCrudRepository<ReservationEntity, Integer> {
    ReservationEntity findAllByTeacherIgnoreCase(String teacher);
}
