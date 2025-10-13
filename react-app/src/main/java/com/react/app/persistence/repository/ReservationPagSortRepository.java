package com.react.app.persistence.repository;

import com.react.app.persistence.entity.ReservationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDateTime;

public interface ReservationPagSortRepository extends PagingAndSortingRepository<ReservationEntity, Integer> {

    Page<ReservationEntity> findByDate(LocalDateTime date, Pageable pageable);

}
