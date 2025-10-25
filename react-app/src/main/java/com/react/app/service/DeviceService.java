package com.react.app.service;

import com.react.app.persistence.entity.DeviceEntity;
import com.react.app.persistence.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceService {
    private final DeviceRepository deviceRepository;

    @Autowired
    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    //Traer toda la lista:
    public List<DeviceEntity> getAll() {
        return this.deviceRepository.findAll();
    }

    //Traer un dispositivo por id:
    public DeviceEntity get(int idDevice) {
        return this.deviceRepository.findById(idDevice).orElse(null);
    }



    //Traer con Query Methods:
    public List<DeviceEntity> getInUse() {
        return this.deviceRepository.findAllByInUseTrue();
    }


    // MÉTODOS SÓLO ADMINISTRADORES (@Secured):
    //Guardar un nuevo dispositivo:
    @Secured("ROLE_ADMIN")
    public DeviceEntity save(DeviceEntity device) {
        return this.deviceRepository.save(device);
    }

    //Borrar un dispositivo
    @Secured("ROLE_ADMIN")
    public void delete(int idDevice) {
        this.deviceRepository.deleteById(idDevice);
    }

    //Actualizar un dispositivo
    @Secured("ROLE_ADMIN")
    public boolean exists(int idDevice) {
        return this.deviceRepository.existsById(idDevice);
    }
}
