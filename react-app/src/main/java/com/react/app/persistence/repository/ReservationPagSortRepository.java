package com.react.app.persistence.repository;

import com.react.app.persistence.entity.ReservationEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ReservationPagSortRepository extends PagingAndSortingRepository<ReservationEntity, Integer> {

}
