package com.react.app.persistence.repository;

import com.react.app.persistence.entity.DeviceEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface DeviceRepository extends ListCrudRepository<DeviceEntity, Integer> {
    List<DeviceEntity> findAllByInUseTrue();
}
