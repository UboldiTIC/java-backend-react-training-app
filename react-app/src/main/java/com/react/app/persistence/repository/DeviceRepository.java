package com.react.app.persistence.repository;

import com.react.app.persistence.entity.DeviceEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface DeviceRepository extends ListCrudRepository<DeviceEntity, Integer> {

}
