package com.react.app.service;

import com.react.app.persistence.entity.DeviceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DeviceService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<DeviceEntity> getAll() {
        return this.jdbcTemplate.query("SELECT * FROM device", new BeanPropertyRowMapper<>(DeviceEntity.class));
    }
}
