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

    //Guardar o crear un nuevo device:
    @PostMapping
    public ResponseEntity<DeviceEntity> add(@RequestBody DeviceEntity device) {
        return ResponseEntity.ok(this.deviceService.save(device));
    }
}
