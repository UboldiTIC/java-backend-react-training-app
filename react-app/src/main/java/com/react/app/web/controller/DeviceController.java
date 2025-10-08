package com.react.app.web.controller;

import com.react.app.persistence.entity.DeviceEntity;
import com.react.app.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/device")
public class DeviceController {
    private final DeviceService deviceService;

    @Autowired
    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    //Traer toda la lista de dispositivos - viene de DeviceService:
    @GetMapping
    public ResponseEntity<List<DeviceEntity>> getAll() {
        return ResponseEntity.ok(this.deviceService.getAll());
    }

    //Traer un dispositivo por id - viene de DeviceService:
    @GetMapping("/{idDevice}")
    public ResponseEntity<DeviceEntity> get(@PathVariable int idDevice) {
        return ResponseEntity.ok(this.deviceService.get(idDevice));
    }

    //Traer un dispositivo por estado disponible - Con Query Methods:
    @GetMapping("status")
    public ResponseEntity<List<DeviceEntity>> getInUse() {
        return ResponseEntity.ok(this.deviceService.getInUse());
    }

    //Guardar o crear un nuevo device:
    @PostMapping
    public ResponseEntity<DeviceEntity> add(@RequestBody DeviceEntity device) {
        if (device.getIdDevice() == null || !this.deviceService.exists(device.getIdDevice())) {
            return ResponseEntity.ok(this.deviceService.save(device));
        }

        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<DeviceEntity> update(@RequestBody DeviceEntity device) {
        if (device.getIdDevice() != null && this.deviceService.exists(device.getIdDevice())) {
            return ResponseEntity.ok(this.deviceService.save(device));
        }

        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{idDevice}")
    public ResponseEntity<Void> delete(@PathVariable int idDevice) {
        if (this.deviceService.exists(idDevice)) {
            this.deviceService.delete(idDevice);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().build();
    }
}
